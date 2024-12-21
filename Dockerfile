# Etapa 1: Compilação da aplicação com Java 21
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app

# Copiar apenas o arquivo de dependências e baixar as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar todo o código-fonte para o contêiner
COPY . .

# Compilar o projeto (gera o JAR final)
RUN mvn clean package -DskipTests

# Etapa 2: Construção da imagem final usando JDK 21
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copiar o JAR gerado na etapa anterior
COPY --from=builder /app/target/apiPontoFuncionario-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta configurada no docker-compose
EXPOSE 8095

# Definir variáveis de ambiente (opcional, pode ser sobrescrito no docker-compose)
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/db_apiPontoFuncionario
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=coti

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
