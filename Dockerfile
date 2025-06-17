# Usa una imagen oficial de Maven para construir el jar
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Ahora usa una imagen Java para correr el jar
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Puerto en el que corre tu Spring Boot (default 8080)
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
