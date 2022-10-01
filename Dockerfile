FROM openjdk:17-ea AS builder
COPY . .
RUN ./gradlew clean npmInstall build

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