# Lightweight Java 17 runtime
FROM eclipse-temurin:21-jre-alpine

# Set working directory (explained below)
WORKDIR /app

# Copy the pre-built JAR (renamed for simplicity)
COPY target/notificationService-0.0.1-SNAPSHOT.jar  notification.jar

# Expose the default Spring Boot port
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "notification.jar"]