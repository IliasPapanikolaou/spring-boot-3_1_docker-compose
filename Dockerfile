FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE="target/spring-boot-3_1_docker-compose-1.0.0.jar"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]