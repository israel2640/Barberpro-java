BarberPro - Sistema de Agendamento para Barbearias
📝 Descrição do Projeto
BarberPro é um sistema web full-stack para gerenciamento de agendamentos em barbearias. O projeto permite que clientes se cadastrem, façam login, visualizem e marquem horários. Do outro lado, os barbeiros também podem se autenticar no sistema para visualizar sua agenda de compromissos.

🎓 Contexto Acadêmico
Este projeto foi desenvolvido como um trabalho prático para o curso técnico de Desenvolvimento de Sistemas da Escola Técnica Estadual Cícero Dias, em Recife-PE. O objetivo foi aplicar os conhecimentos de desenvolvimento back-end com Java e Spring Boot, integrando com um front-end funcional para criar uma aplicação web completa e realista.

✨ Funcionalidades Principais
Autenticação de Usuários: Sistema de login seguro com Tokens JWT.

Controle de Acesso por Papel (Role): Distinção entre usuários CLIENTE e BARBEIRO.

CRUD de Agendamentos (para Clientes):

Criação: Clientes podem agendar um novo horário com seu barbeiro e serviço de preferência.

Leitura: Clientes podem visualizar uma lista de seus próprios agendamentos.

Exclusão: Clientes podem cancelar um agendamento existente.

Dashboard do Barbeiro:

Barbeiros podem fazer login e visualizar uma lista de todos os seus compromissos agendados.

Carregamento Dinâmico: As listas de barbeiros e serviços são carregadas dinamicamente da API no front-end.

🚀 Tecnologias Utilizadas
Back-end
Java 17+

Spring Boot 3: Framework principal para a construção da API REST.

Spring Security: Para gerenciamento de autenticação e autorização.

Spring Data JPA: Para persistência de dados e comunicação com o banco.

Hibernate: Implementação da especificação JPA.

JWT (Java Web Token): Para a criação de tokens de autenticação stateless.

Maven: Gerenciador de dependências do projeto.

Front-end
HTML5

CSS3

JavaScript (ES6+): Utilizando a Fetch API para comunicação com o back-end.

Banco de Dados
MySQL: Sistema de gerenciamento de banco de dados relacional.

Ferramentas e Ambiente
IntelliJ IDEA: IDE de desenvolvimento.

MySQL Workbench: Para modelagem e gerenciamento do banco de dados.

Git & GitHub: Para versionamento de código.

⚙️ Como Executar o Projeto
Siga os passos abaixo para executar a aplicação localmente.

Pré-requisitos
JDK 17 ou superior

Maven 3.8+

MySQL 8.0+

Uma IDE Java (ex: IntelliJ, Eclipse)

Um servidor web para o front-end (como a extensão Live Server do VSCode)

1. Configuração do Back-end
Bash

# Clone o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

# Navegue até a pasta do projeto
cd seu-repositorio
Abra o projeto na sua IDE.

Crie um banco de dados no MySQL com o nome barberpro_java_db.

Execute o script SQL fornecido no projeto para criar as tabelas e popular os dados iniciais.

Configure o arquivo src/main/resources/application.properties com suas credenciais do banco de dados e uma chave secreta para o JWT:

Properties

spring.datasource.url=jdbc:mysql://localhost:3306/barberpro_java_db
spring.datasource.username=root
spring.datasource.password=sua_senha_do_mysql

api.security.token.secret=sua-chave-secreta-para-o-jwt
Execute a classe principal ApiApplication.java para iniciar o servidor back-end na porta 8080.

2. Execução do Front-end
Navegue até a pasta dos arquivos HTML (/src/main/resources/static ou a pasta onde eles estiverem).

Abra os arquivos com um servidor local (como o Live Server no VSCode). Isso é importante para evitar problemas de CORS.

Certifique-se de que a variável API_URL nos arquivos JavaScript (agendamento.html, registrar.html, etc.) está apontando para http://localhost:8080.

👨‍💻 Autor
<img src="URL_DA_SUA_FOTO_AQUI" width=115><br><sub>[COLOQUE SEU NOME AQUI]</sub>

Exportar para as Planilhas
🙏 Agradecimentos
Agradecimentos ao professor [Vinicios] e à ETE Cícero Dias pela orientação e oportunidade de desenvolver este projeto.