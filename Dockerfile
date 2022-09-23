FROM openjdk:17-ea AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM openjdk:17-ea
COPY --from=builder build/libs/*.jar app.jar

#ARG JAR_FILE
ARG DATABASE_USERNAME
ARG DATABASE_PASSWORD
ARG DATABASE_URL
ARG TOSS_CLIENT_KEY
ARG TOSS_SECRET_KEY

#COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.edg=file:/dev/./urandom","-jar","/app.jar"]