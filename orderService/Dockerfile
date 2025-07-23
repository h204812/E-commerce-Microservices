FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/orderService-0.0.1-SNAPSHOT.jar orderservice.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar","orderservice.jar"]
