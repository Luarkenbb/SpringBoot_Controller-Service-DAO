# Use an official Maven image as the base image
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file to the working directory
COPY ./app/pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline -B

# Copy the source code to the working directory
COPY ./app/src ./src

# Build the Maven project
RUN mvn package -DskipTests

# Use a lightweight Java image as the base image for the final image
FROM openjdk:21

# Copy the built JAR file from the previous stage to the working directory
COPY --from=build /app/target/*.jar ./target/app.jar

# Expose the port that the application will listen on
EXPOSE 8080

# Set the command to run the application
CMD ["java", "-jar", "target/app.jar"]
