#!/usr/bin/env bash
set -euo pipefail

JETTY_VER="12.0.17"
KEYSTORE_PASSWORD="${KEYSTORE_PASSWORD:-changeit}"

BASE_DIR="$(pwd)"
JETTY_HOME_DIR="$BASE_DIR/jetty-home-$JETTY_VER"
JETTY_BASE_DIR="$BASE_DIR/jetty-base"
WAR_SRC="$(ls -1 "$BASE_DIR"/build/libs/*.war 2>/dev/null | head -n1 || true)"

die(){ echo "ERROR: $*" >&2; exit 1; }

# --- Проверки
command -v java >/dev/null || die "Java не найдена в PATH."
[[ -f "$BASE_DIR/certs/server.p12" ]] || die "Нет certs/server.p12"
[[ -n "${WAR_SRC}" && -f "${WAR_SRC}" ]] || die "WAR не найден в build/libs/*.war"

# --- Функция скачивания (curl|wget)
download() {
  local url="$1" out="$2"
  if command -v curl >/dev/null; then
    curl -fsSL "$url" -o "$out"
  elif command -v wget >/dev/null; then
    wget -qO "$out" "$url"
  else
    die "Нужен curl или wget для скачивания $url"
  fi
}

# --- Скачиваем/разворачиваем Jetty HOME
if [[ ! -d "$JETTY_HOME_DIR" ]]; then
  TARBALL="jetty-home-$JETTY_VER.tar.gz"
  URL="https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/$JETTY_VER/jetty-home-$JETTY_VER.tar.gz"
  echo "[jetty] downloading $URL"
  download "$URL" "$TARBALL"
  tar -xzf "$TARBALL"
  rm -f "$TARBALL"
fi

# --- Готовим JETTY_BASE
mkdir -p "$JETTY_BASE_DIR"
export JETTY_HOME="$JETTY_HOME_DIR"
export JETTY_BASE="$JETTY_BASE_DIR"

# Подключаем нужные модули (идемпотентно)
java -jar "$JETTY_HOME/start.jar" \
  --add-modules=ssl,https,ee10-webapp,ee10-deploy,ee10-jsp,ee10-jstl

# Конфиг SSL
mkdir -p "$JETTY_BASE/etc" "$JETTY_BASE/start.d" "$JETTY_BASE/webapps"
cp -f "$BASE_DIR/certs/server.p12" "$JETTY_BASE/etc/keystore.p12"

SSL_INI="$JETTY_BASE/start.d/ssl.ini"
HTTPS_INI="$JETTY_BASE/start.d/https.ini"

# ssl.ini
grep -q '^jetty.sslContext.keyStorePassword=' "$SSL_INI" 2>/dev/null || {
  {
    echo "jetty.sslContext.keyStorePath=\${jetty.base}/etc/keystore.p12"
    echo "jetty.sslContext.keyStoreType=PKCS12"
    echo "jetty.sslContext.keyStorePassword=$KEYSTORE_PASSWORD"
    echo "jetty.sslContext.keyManagerPassword=$KEYSTORE_PASSWORD"
    echo "jetty.sslContext.includeProtocols=TLSv1.3,TLSv1.2"
  } >> "$SSL_INI"
}

# https.ini — выставим порт и отключим http
if [[ -f "$HTTPS_INI" ]]; then
  sed -i -E 's|^#?jetty\.https\.port=.*|jetty.https.port=8443|' "$HTTPS_INI"
else
  echo "jetty.https.port=8443" > "$HTTPS_INI"
fi
# На всякий случай уберем http.ini, если вдруг появился
rm -f "$JETTY_BASE/start.d/http.ini" 2>/dev/null || true

# Деплой WAR как ROOT
cp -f "$WAR_SRC" "$JETTY_BASE/webapps/ROOT.war"

echo "[jetty] starting on https://0.0.0.0:8443"


exec java -Djetty.base="$JETTY_BASE" -jar "$JETTY_HOME/start.jar"


