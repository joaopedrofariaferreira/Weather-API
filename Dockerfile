# Usar uma imagem base do OpenJDK
FROM openjdk:21-jdk-slim

# Informações sobre o autor
LABEL maintainer="joaopedrofariaferreira"

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Maven para o container
COPY target/weather-api-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta padrão do Spring Boot
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]