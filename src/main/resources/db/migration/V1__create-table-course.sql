-- Tabela de Cursos
-- Armazena os cursos aos quais os tópicos podem ser associados.

CREATE TABLE course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL
);