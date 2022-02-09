# base image
FROM adoptopenjdk/openjdk11:alpine-jre

# Changed the working directory to /opt
WORKDIR /opt

ENV PORT 8080
EXPOSE 8080

# Refer to Maven build -> finalName
ARG JAR_FILE=target/springboot-k8s-app.jar

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} /opt/app.jar

#Entry point
ENTRYPOINT ["java","-jar","app.jar"]
