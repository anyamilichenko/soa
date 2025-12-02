-- Временная таблица, которая будет генерироваться первой и "отвлекать" jOOQ
CREATE TABLE IF NOT EXISTS __jooq_temp_fix (
                                               id BIGSERIAL PRIMARY KEY,
                                               dummy_field VARCHAR(10) DEFAULT 'dummy'
);

-- Создаем таблицу coordinates
CREATE TABLE coordinates (
                             id BIGSERIAL PRIMARY KEY,
                             x BIGINT NOT NULL CHECK (x > -446),
                             y DOUBLE PRECISION NOT NULL CHECK (y <= 860)
);

-- Создаем таблицу dragon_head
CREATE TABLE dragon_head (
                             id BIGSERIAL PRIMARY KEY,
                             eyes_count INTEGER NOT NULL
);

-- Создаем таблицу dragon
CREATE TABLE dragon (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR NOT NULL CHECK (name <> ''),
                        coordinates_id BIGINT NOT NULL REFERENCES coordinates(id),
                        creation_date TIMESTAMPTZ NOT NULL,
                        age INTEGER NOT NULL CHECK (age > 0),
                        description VARCHAR NOT NULL,
                        color VARCHAR,
                        type VARCHAR NOT NULL,
                        head_id BIGINT REFERENCES dragon_head(id)
);

-- Устанавливаем значения по умолчанию
ALTER TABLE dragon
    ALTER COLUMN creation_date SET DEFAULT now();

-- Вставляем dummy-запись в временную таблицу
INSERT INTO __jooq_temp_fix (dummy_field) VALUES ('jooq-fix')
ON CONFLICT DO NOTHING;