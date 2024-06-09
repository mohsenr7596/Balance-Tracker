# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the project's JAR file into the container at /app
COPY target/app.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]