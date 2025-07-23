# Lightweight Java 17 runtime
FROM eclipse-temurin:21-jre-alpine

# Set working directory (explained below)
WORKDIR /app

# Copy the pre-built JAR (renamed for simplicity)
COPY target/Inventory-0.0.1-SNAPSHOT.jar  inventory.jar

# Expose the default Spring Boot port
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "inventory.jar"]