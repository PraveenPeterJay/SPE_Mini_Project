# =============================
# Step 1: Build Stage
# =============================
FROM maven:3.9.6-eclipse-temurin-20 AS build

WORKDIR /app

# Copy pom.xml first to cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# =============================
# Step 2: Runtime Stage
# =============================
FROM eclipse-temurin:20-jdk-jammy

WORKDIR /app

# Copy built JAR
COPY --from=build /app/target/*.jar app.jar

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
