# Use a imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho no container
WORKDIR /src

# Copie o arquivo JAR gerado pelo Maven para dentro do container
COPY target/*.jar app.jar

# Expor a porta 8080 para a aplicação Spring Boot
EXPOSE 8080

# Defina o comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
