FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/triangle-app-1.0.0.jar app.jar
CMD ["java", "-jar", "app.jar"]