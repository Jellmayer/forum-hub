-- Tabela de Respostas
-- Armazena as respostas associadas a cada tópico.
CREATE TABLE answer (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     message TEXT NOT NULL,
     creation_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
     solution BOOLEAN DEFAULT FALSE,
     author_id BIGINT NOT NULL,
     topic_id BIGINT NOT NULL,
     FOREIGN KEY (author_id) REFERENCES user(id),
     FOREIGN KEY (topic_id) REFERENCES topic(id)
);