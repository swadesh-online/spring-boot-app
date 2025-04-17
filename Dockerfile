# ---------- Stage 1: Build ----------
FROM maven:3-sapmachine-24 AS build

WORKDIR /app

# Copy only pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Now copy the rest of the project
COPY src ./src

# Package the app
RUN mvn clean package -DskipTests

# ---------- Stage 2: Run ----------
FROM eclipse-temurin:24-alpine

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar my-spring-boot-app.jar

# Expose the application port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "--enable-preview", "-jar", "my-spring-boot-app.jar"]
