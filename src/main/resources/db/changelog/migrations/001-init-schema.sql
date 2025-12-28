-- Миграция 001: Создание таблицы специалистов

CREATE TABLE specialists (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    specialization VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Комментарии для документации
COMMENT ON TABLE specialists IS 'Специалисты, которые проводят консультации';
COMMENT ON COLUMN specialists.specialization IS 'Направление: кредитование, инвестиции, ипотека и т.д.';