FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package


FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY --from=MAVEN_BUILD /tmp/${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]