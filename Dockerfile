
FROM eclipse-temurin:20-jdk-alpine
WORKDIR /app
COPY target/*.jar application.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
