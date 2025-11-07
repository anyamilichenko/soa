FROM jetty:12.0.17-jdk21-eclipse-temurin

ENV KEYSTORE_PASSWORD=changeit

USER root
RUN mkdir -p /var/lib/jetty/etc && chown -R jetty:jetty /var/lib/jetty
COPY --chown=jetty:jetty certs/server.p12 /var/lib/jetty/etc/keystore.p12


RUN java -jar "$JETTY_HOME/start.jar" --add-modules=ssl,https,ee10-webapp,ee10-deploy,ee10-jsp,ee10-jstl && \
    printf 'jetty.sslContext.keyStorePassword=%s\n' "$KEYSTORE_PASSWORD" >> "$JETTY_BASE/start.d/ssl.ini" && \
    printf 'jetty.sslContext.keyManagerPassword=%s\n' "$KEYSTORE_PASSWORD" >> "$JETTY_BASE/start.d/ssl.ini" && \
    printf 'jetty.sslContext.keyStoreType=PKCS12\n' >> "$JETTY_BASE/start.d/ssl.ini" && \
    printf 'jetty.sslContext.includeProtocols=TLSv1.3,TLSv1.2\n' >> "$JETTY_BASE/start.d/ssl.ini" && \
    sed -ri "s|^#?jetty\.https\.port=.*|jetty.https.port=8443|" "$JETTY_BASE/start.d/https.ini" && \
    rm -f "$JETTY_BASE/start.d/http.ini"

COPY --chown=jetty:jetty build/libs/*.war /var/lib/jetty/webapps/ROOT.war

EXPOSE 8443
USER jetty
CMD ["java","-jar","/usr/local/jetty/start.jar"]
