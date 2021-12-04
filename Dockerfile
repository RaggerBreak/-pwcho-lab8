# Build
FROM maven:3.6.0-jdk-11-slim AS build
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package

# Run
FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
EXPOSE 8080
MAINTAINER ragger.break@gmail.com
COPY --from=build /app/target/pwcho-lab8-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]