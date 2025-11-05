# Estágio 1: Build da aplicação com Maven
# Usamos uma imagem que já tem o Maven e o Java 17 instalados
FROM maven:3.8-openjdk-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo de configuração do Maven para baixar as dependências
COPY pom.xml .

# Copia o restante do código-fonte da API
COPY src ./src

# Executa o comando do Maven para compilar e empacotar a aplicação em um .jar
# O -DskipTests pula a execução de testes para acelerar o build
RUN mvn clean install -DskipTests

# Estágio 2: Execução da aplicação
# Usamos uma imagem leve, que contém apenas o Java 17 para rodar
FROM eclipse/temurin:17-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo .jar que foi gerado no estágio de build
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar .

# Expõe a porta 8080, que é a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação quando o container for executado
ENTRYPOINT ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]