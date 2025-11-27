# Etapa 1: Construir el JAR con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copiamos todo el código del repositorio
COPY . .

# Construimos el proyecto usando el pom que está dentro de la carpeta "consultas-camel"
RUN mvn -f consultas-camel/pom.xml clean package -DskipTests

# Etapa 2: Imagen final basada solo en el JAR ya construido
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiamos el JAR generado en la etapa builder
COPY --from=builder /app/consultas-camel/target/*.jar app.jar

# Exponemos el puerto donde corre Spring Boot
EXPOSE 8080

# Comando de arranque del contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]
