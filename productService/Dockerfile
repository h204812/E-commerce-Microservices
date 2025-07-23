# Lightweight Java 17 runtime
FROM eclipse-temurin:21-jre-alpine

# Set working directory (explained below)
WORKDIR /app

# Copy the pre-built JAR (renamed for simplicity)
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]