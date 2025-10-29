# 💈 BarberPro - Sistema de Agendamento

Este é um sistema completo de agendamento e gerenciamento para barbearias, construído com uma arquitetura moderna e desacoplada. A aplicação separa totalmente o **Frontend** (interface do cliente) do **Backend** (lógica de negócios e API).

O sistema atende a três perfis de usuário distintos:
* **Cliente:** Pode se cadastrar, fazer login, agendar serviços e gerenciar seus próprios agendamentos.
* **Barbeiro (Profissional):** Possui um login exclusivo para acessar sua agenda, visualizar seus horários e marcar serviços como concluídos.
* **Administrador:** Tem acesso a um painel de controle completo para gerenciar clientes, barbeiros (CRUD) e visualizar todos os agendamentos do sistema.

---

## 🚀 Links de Produção (Live Demo)

O projeto está implantado na plataforma **Render**:

* **Frontend (Site):** [https://barberpro-frontend.onrender.com](https://barberpro-frontend.onrender.com)
* **Backend (API):** [https://barberpro-api-1o2y.onrender.com](https://barberpro-api-1o2y.onrender.com)

---

## 🛠️ Tecnologias Utilizadas

O projeto é dividido em duas partes principais:

### Backend (API)
* **Java 17**
* **Spring Boot 3**
* **Spring Security (JWT):** Para autenticação baseada em token.
* **Spring Data JPA:** Para abstração e comunicação com o banco de dados.
* **PostgreSQL:** Banco de dados relacional.

### Frontend
* **HTML5**
* **CSS3 (com layout responsivo)**
* **JavaScript (Vanilla JS):** Para consumir a API (com `fetch`) e gerenciar o estado.

---

## 🏛️ Arquitetura da Solução

O sistema segue um modelo Cliente-Servidor desacoplado, onde o Frontend é um "Site Estático" que consome os dados de um "Web Service" (API RESTful).

[ Usuário (Browser) ] | v [ Frontend (Render Static Site) ] (HTML/CSS/JS) | | <--- Requisições HTTP (Fetch) para a API v [ Backend API (Render Web Service) ] (Java / Spring Boot) | | <--- Conexão JDBC (via Spring Data JPA) v [ Banco de Dados (Render PostgreSQL) ] (PostgreSQL)


### Segurança
A segurança é gerenciada 100% pelo Backend com Spring Security.

1.  **Autenticação:** O usuário envia `email` e `senha` para os endpoints `/login` ou `/login/barbeiro`. O `TokenService` gera um **Token JWT**.
2.  **Autorização:** O token é salvo no `localStorage` do navegador (com chaves diferentes para Cliente, Barbeiro e Admin) e enviado em todas as requisições futuras no cabeçalho `Authorization`.
3.  **Filtro:** O `SecurityFilter.java` intercepta cada requisição, valida o token e verifica as permissões (Roles) do usuário.
4.  **Roles:** O `SecurityConfig.java` define quais "Roles" (`ROLE_USER`, `ROLE_BARBER`, `ROLE_ADMIN`) podem acessar quais endpoints.
5.  **CORS:** O `CorsConfig.java` garante que o Backend só aceite requisições vindas do domínio do Frontend (`https://barberpro-frontend.onrender.com`).

---

## 🗺️ Principais Endpoints da API

A tabela abaixo detalha as rotas principais da API e quem pode acessá-las:

| Método | URL | Papel Necessário | Descrição |
| :--- | :--- | :--- | :--- |
| POST | `/login` | Público | Autentica um cliente ou administrador. |
| POST | `/login/barbeiro` | Público | Autentica um barbeiro. |
| POST | `/clientes` | Público | Cadastra um novo cliente. |
| GET | `/api/dados/barbeiros` | Público | Lista todos os barbeiros disponíveis. |
| GET | `/api/dados/servicos` | Público | Lista todos os serviços oferecidos. |
| GET | `/agendamentos` | USER | Lista os agendamentos do cliente logado. |
| POST | `/agendamentos` | USER | Cria um novo agendamento para o cliente logado. |
| GET | `/barbeiro/agendamentos` | BARBER | Lista os agendamentos do barbeiro logado. |
| PATCH | `/agendamentos/{id}/concluir` | BARBER | Marca um agendamento como concluído. |
| DELETE | `/agendamentos/{id}` | USER, BARBER | Cancela um agendamento (com verificação de posse). |
| GET | `/admin/agendamentos` | ADMIN | Lista todos os agendamentos do sistema. |
| GET | `/admin/usuarios` | ADMIN | Lista todos os clientes. |
| GET | `/admin/barbeiros` | ADMIN | Lista todos os barbeiros. |
| POST | `/admin/barbeiros` | ADMIN | Cria um novo barbeiro. |
| PUT | `/admin/barbeiros/{id}` | ADMIN | Edita os dados de um barbeiro. |
| DELETE | `/admin/barbeiros/{id}` | ADMIN | Exclui um barbeiro. |

---

## 🚀 Como Executar Localmente

Siga os passos abaixo para rodar o projeto em sua máquina local.

### Backend (API)
1.  Clone o repositório.
2.  Abra a pasta `barberpro-api` em sua IDE Java (IntelliJ, VS Code, etc.).
3.  Configure as **Variáveis de Ambiente** necessárias para o Spring Boot se conectar ao seu banco PostgreSQL local:
    * `SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/nome_do_seu_banco`
    * `SPRING_DATASOURCE_USERNAME=seu_usuario_postgres`
    * `SPRING_DATASOURCE_PASSWORD=sua_senha_postgres`
    * `api.security.token.secret=seu_segredo_jwt_customizado`
4.  Execute a classe principal `ApiApplication.java`.
5.  A API estará disponível em `http://localhost:8080`.

### Frontend
1.  Abra a pasta `barberpro-frontend` no VS Code.
2.  Nos arquivos JavaScript (`agendamento.html`, `registrar.html`, etc.), altere a constante `API_URL` para apontar para o seu backend local:
    * `const API_URL = "http://localhost:8080";`
3.  Abra os arquivos `.html` diretamente no navegador. (É recomendado usar a extensão "Live Server" do VS Code).

---

## 👤 Autor

* **Israel Paz** - *Desenvolvimento Full Stack e Documentação*
