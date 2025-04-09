# Usa imagem base do Java 17
FROM openjdk:17-jdk-slim

# Cria diretório de trabalho dentro do container
WORKDIR /app

# Copia o .jar gerado localmente para dentro do container
COPY target/servidores-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080 (padrão do Spring Boot)
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]