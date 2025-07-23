# Lightweight Java 17 runtime
FROM eclipse-temurin:21-jre-alpine

# Set working directory (explained below)
WORKDIR /app

# Copy the pre-built JAR (renamed for simplicity)
COPY target/api-gateway-0.0.1-SNAPSHOT.jar  api-gateway.jar

# Expose the default Spring Boot port
EXPOSE 9000

# Run the application
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]