FROM eclipse-temurin:21-jdk-jammy

ARG JAR_FILE=target/orders-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080/tcp

ENTRYPOINT ["java","-jar","/app.jar"]