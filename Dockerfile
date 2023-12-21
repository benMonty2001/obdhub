FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY . .
ENTRYPOINT ["./gradlew","bootRun"]
EXPOSE 8080
