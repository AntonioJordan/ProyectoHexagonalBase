
FROM eclipse-temurin:20-jdk-alpine
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]