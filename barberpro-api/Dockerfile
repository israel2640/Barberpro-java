# Estágio Único: Construir e Rodar
# Sabemos que o Render consegue baixar esta imagem!
FROM maven:3.8-openjdk-17

# Define o diretório de trabalho
WORKDIR /app

# Copia o 'plano' do projeto
COPY pom.xml .

# Copia todo o código-fonte
COPY src ./src

# Constrói a aplicação. O JAR será criado em /app/target/
# Usamos -DskipTests para acelerar o build no Render
RUN mvn clean package -DskipTests

# Expõe a porta que o Spring Boot usa
EXPOSE 8080

# Comando para rodar a aplicação quando o container iniciar
# ATENÇÃO: Verifique se o nome do seu .jar é exatamente este.
# Este é o nome padrão do Spring Boot.
ENTRYPOINT ["java", "-jar", "target/api-0.0.1-SNAPSHOT.jar"]