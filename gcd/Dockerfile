# Use a maven image to build the application
FROM maven:3.8.2-adoptopenjdk-16 AS mavenbuild
COPY pom.xml /tmp/
COPY src /tmp/src
WORKDIR /tmp/
RUN mvn package

# Now create the distributable image
FROM adoptopenjdk:16.0.1_9-jdk-hotspot-focal
COPY --from=mavenbuild /tmp/target/*-SNAPSHOT.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
