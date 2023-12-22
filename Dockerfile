FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY --chown=500:500 . .
RUN chomd +x gradlew && ./gradlew clean assemble
COPY --chown=500:500 build/libs/*.jar /app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
EXPOSE 8080
