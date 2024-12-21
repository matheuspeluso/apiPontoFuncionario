# Etapa 1: Build
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app

# Copiar o arquivo de dependências e baixar as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar o código-fonte e compilar o projeto
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagem de execução
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar o JAR gerado na etapa anterior
COPY --from=builder /app/target/apiPontoFuncionario-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta configurada no projeto
EXPOSE 8095

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
