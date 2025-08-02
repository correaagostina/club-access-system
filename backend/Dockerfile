# Etapa 1: build
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Copia el código fuente y construye el JAR
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

# Etapa 2: runtime
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el JAR generado desde la etapa anterior
COPY --from=build /app/target/club-access-backend-1.0.0.jar app.jar

# Expone el puerto
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]
