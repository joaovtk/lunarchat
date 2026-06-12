FROM alpine

RUN apk add maven openjdk17-jdk
WORKDIR /app

COPY pom.xml /app/
RUN mvn clean install

COPY target/lunarchat-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080
RUN java -jar lunarchat-0.0.1-SNAPSHOT.jar