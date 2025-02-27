
FROM eclipse-temurin:20-jdk-alpine
WORKDIR /app
COPY application.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]