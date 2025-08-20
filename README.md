# ForumHub API 🚀

![Status do Projeto](https://img.shields.io/badge/status-in_progress-green)
![Linguagem](https://img.shields.io/badge/java-24-blue)
![Framework](https://img.shields.io/badge/spring%20boot-3.3.0-brightgreen)

## 📝 Descrição

O **ForumHub** é uma API REST desenvolvida em Java com Spring Boot, que simula o back-end de um fórum de discussões. A aplicação permite que os usuários se cadastrem, façam login, criem, visualizem, atualizem e deletem tópicos de discussão, que por sua vez estão associados a diferentes cursos. O projeto foi criado como parte do desafio de back-end do programa ONE (Oracle Next Education) em parceria com a Alura.



## ✨ Funcionalidades Principais

* **🔐 Autenticação e Autorização:** Sistema de login com JSON Web Tokens (JWT) para proteger os endpoints.
* **💬 Gestão de Tópicos:** CRUD (Criar, Ler, Atualizar, Deletar) completo para os tópicos do fórum.
* **✅ Validações:** Regras de negócio para evitar a duplicação de tópicos e garantir a integridade dos dados.
* **🗃️ Banco de Dados:** Uso de Flyway para gerenciar as migrações do banco de dados de forma versionada e automática.


## Próximos Passos
* Implementar respostas para os tópicos
* Documentar a API
* Adicionar verificações na criação de usuário, com o desenvolvimento da classe UserService



## 🛠️ Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias:

* **Java 24**
* **Spring Boot 3**
* **Spring Security:** Para gerenciamento de autenticação e autorização.
* **JPA (Java Persistence API) / Hibernate:** Para o mapeamento objeto-relacional e persistência de dados.
* **Maven:** Gerenciador de dependências do projeto.
* **MySQL:** Banco de dados relacional para armazenamento das informações.
* **Flyway:** Ferramenta para controle de versão do banco de dados.
* **Lombok:** Para omissão de código repetitivo (getters, setters, construtores).
* **Auth0 (Java JWT):** Biblioteca para a criação e validação dos tokens JWT.



## Endpoints da API

A API expõe os seguintes endpoints para interação:

| Método | Rota               | Descrição                                         | Requer Autenticação? |
| :----- | :----------------- | :------------------------------------------------ | :------------------- |
| `POST` | `/login`           | Autentica um usuário e retorna um token JWT.      | Não                  |
| `POST` | `/user`           | Cadastra um novo usuário.                         | Não                  |
| `GET` | `/user/{id}`     | Exibe os detalhes de um usuário específico.        | Sim                  |
| `GET` | `/topic`          | Lista todos os tópicos cadastrados.               | Sim                  |
| `GET` | `/topic/{id}`     | Exibe os detalhes de um tópico específico.        | Sim                  |
| `POST` | `/topic`          | Cria um novo tópico.                              | Sim                  |
| `PUT` | `/topic/{id}`     | Atualiza as informações de um tópico existente.   | Sim                  |
| `DELETE` | `/topic/{id}`     | Remove um tópico do sistema.                      | Sim                  |
| `POST` | `/course`         | Cria um novo curso.                               | Sim                  |



## 🚀 Como Executar o Projeto

Siga os passos abaixo para configurar e executar o projeto em seu ambiente local.

### Pré-requisitos

* **Java JDK 24**
* **Maven 3.8**
* **MySQL 8** ou um banco de dados compatível.
* Uma IDE de sua preferência (IntelliJ, VS Code, Eclipse).
* Um cliente de API como [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/) para testar os endpoints.

### Passos para Instalação

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/forum-hub.git](https://github.com/seu-usuario/forum-hub.git)
    cd forum-hub
    ```

2.  **Configure o Banco de Dados:**
    * Crie um banco de dados no MySQL:
        ```sql
        CREATE DATABASE forumhub_api;
        ```
    * Abra o arquivo `src/main/resources/application.properties`.
    * Altere as propriedades `spring.datasource.url`, `spring.datasource.username` e `spring.datasource.password` com as suas credenciais do MySQL.

3.  **(OPCIONAL) Configure a Chave Secreta do JWT:**
No mesmo arquivo `application.properties`, altere o valor de `api.security.token.secret` para sua chave secreta ou seu nome de variável ambiente.

Se essa etapa for pulada, a chave secreta padrão declarada em `api.security.token.secret` será usada.
    

4.  **Execute a Aplicação**

5.  **Teste usando Postman ou Insomnia**



## 👨‍💻 Autoria

Projeto desenvolvido por **Thais Jellmayer** como parte do programa Alura ONE.

