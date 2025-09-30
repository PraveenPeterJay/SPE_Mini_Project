# Use just the JDK to run the jar
FROM eclipse-temurin:20-jdk

WORKDIR /app

# Copy the JAR built by Jenkins
COPY target/SPE_Mini_Project-1.0-SNAPSHOT.jar app.jar

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
