💈 BarberPro - Sistema de Agendamento para Barbearias
<p align="center">
<img src="BARBERPRO/imagens/Logo.png" alt="Banner do BarberPro">
</p>

<p align="center">
<img alt="Status do Projeto" src="https://img.shields.io/badge/STATUS-Em%20Desenvolvimento-yellow">
</p>

📝 Visão Geral do Projeto
BarberPro é um sistema web full-stack para gerenciamento de agendamentos em barbearias. O projeto permite que clientes se cadastrem, façam login e marquem horários. Do outro lado, os barbeiros podem se autenticar no sistema para visualizar sua agenda de compromissos. Este projeto foi desenvolvido para aplicar de forma prática os conhecimentos adquiridos no curso técnico de Desenvolvimento de Sistemas.

✨ Funcionalidades Principais
Autenticação Segura: Sistema de login com Tokens JWT para garantir a segurança dos dados.

Controle de Acesso por Papel: Distinção clara entre perfis de CLIENTE e BARBEIRO, com permissões diferentes.

Gestão de Agendamentos (Cliente):

Criação: Clientes podem agendar um novo horário com seu barbeiro e serviço de preferência.

Leitura: Clientes podem visualizar uma lista de seus próprios agendamentos.

Exclusão: Clientes podem cancelar um agendamento existente.

Painel do Barbeiro:

(Em desenvolvimento) Área para barbeiros visualizarem e gerenciarem seus compromissos.

Carregamento Dinâmico: As listas de barbeiros e serviços são carregadas dinamicamente da API REST no front-end.

🚀 Tecnologias Utilizadas
O projeto foi construído utilizando as seguintes tecnologias:

Tecnologia	Descrição
Java 17	Linguagem principal do back-end.
Spring Boot 3	Framework para a construção da API REST.
Spring Security	Gerenciamento de autenticação e autorização com JWT.
Spring Data JPA	Persistência de dados e comunicação com o banco.
MySQL	Banco de dados relacional para armazenamento dos dados.
HTML5 / CSS3	Estrutura e estilo do front-end.
JavaScript (ES6+)	Lógica do front-end e comunicação com a API (Fetch API).
Git & GitHub	Versionamento e armazenamento do código.

Exportar para as Planilhas
🖼️ Layout (Preview)
(Dica: Grave um GIF curto mostrando o fluxo de agendamento e coloque aqui. Fica muito profissional!)

<p align="center">
<img src="URL_DO_SEU_GIF_OU_IMAGEM_AQUI" alt="Demonstração do Projeto">
</p>

⚙️ Como Executar o Projeto Localmente
Siga os passos abaixo para executar a aplicação na sua máquina.

Pré-requisitos
JDK 17

Maven 3.8+

Uma IDE Java (ex: IntelliJ IDEA)

1. Configuração do Back-end
Bash

# Clone o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

# Navegue até a pasta do projeto
cd seu-repositorio
Abra o projeto na sua IDE.

Crie um banco de dados no MySQL com o nome barberpro_java_db.

No arquivo src/main/resources/application.properties, configure suas credenciais do banco e a chave secreta do JWT:

Properties

spring.datasource.url=jdbc:mysql://localhost:3306/barberpro_java_db
spring.datasource.username=seu_usuario_mysql
spring.datasource.password=sua_senha_mysql

api.security.token.secret=sua-chave-secreta-para-o-jwt
Execute a classe principal ApiApplication.java para iniciar o servidor back-end (porta 8080).

2. Execução do Front-end
Abra a pasta dos arquivos HTML (ex: /src/main/resources/static).

Use um servidor local (como a extensão Live Server do VSCode) para servir os arquivos e evitar problemas de CORS.

Verifique se a variável API_URL nos arquivos JavaScript está apontando para http://localhost:8080.

👨‍💻 Autor
Feito com ❤️ por [Israel Paz].

<img src="BARBERPRO/imagens/israel-paz.jpg" width=115><br>

🙏 Agradecimentos
Agradecimentos especiais ao professores Emerson, Breno e Vinícius e à ETE Cícero Dias pela orientação e oportunidade de desenvolver este projeto.

