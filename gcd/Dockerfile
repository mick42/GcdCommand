# Use a maven image to build the application
FROM maven:3.6.3-openjdk-14-slim AS mavenbuild
COPY pom.xml /tmp/
COPY src /tmp/src
WORKDIR /tmp/
RUN mvn package

# Now create the distributable image
FROM openjdk:14.0.1-jdk-oraclelinux7
COPY --from=mavenbuild /tmp/target/*-SNAPSHOT.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
