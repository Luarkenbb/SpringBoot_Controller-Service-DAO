# Use an official Maven image as the base image
FROM maven:3.9.6-eclipse-temurin-21 AS build

ENV HOME=/usr/src/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD ./demo $HOME

RUN mvn clean package -DskipTests=true



# Use a lightweight Java image as the base image for the final image
FROM openjdk:21
ENV HOME=/usr/src/app
RUN mkdir -p $HOME

COPY --from=build $HOME/target/*.jar $HOME/app.jar
WORKDIR $HOME

ENV SERVER_PORT=8080


# Expose the port that the application will listen on
EXPOSE $SERVER_PORT

ENTRYPOINT [ "java", "-jar", "app.jar" ]
