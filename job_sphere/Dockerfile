# Use Maven to build the project
FROM maven:3.8.6-eclipse-temurin-17 AS BUILDER

WORKDIR build

COPY src src
COPY pom.xml pom.xml

RUN mvn clean package

# Use a lightweight JDK image to run the built JAR
FROM bellsoft/liberica-openjdk-alpine:17.0.3

WORKDIR /usr/share/app

COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
