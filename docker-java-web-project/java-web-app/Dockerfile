FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/java-web-app-1.0-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]