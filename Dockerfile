FROM openjdk:11

ARG JAR_FILE=target/send-email.jar

COPY ${JAR_FILE} send-email.jar

ENTRYPOINT ["java", "-jar", "/send-email.jar"]