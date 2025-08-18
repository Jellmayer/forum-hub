-- Tabela de Usuários
-- Armazena as informações dos usuários do fórum.

CREATE TABLE user (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(100) NOT NULL,
   email VARCHAR(100) NOT NULL UNIQUE,
   password VARCHAR(255) NOT NULL
);