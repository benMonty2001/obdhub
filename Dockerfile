FROM azul/zulu-openjdk:17-latest
VOLUME /tmp
COPY --chown=500:500 . .
RUN chmod +x gradlew && ./gradlew clean assemble
COPY --chown=500:500 build/libs/*.jar /app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
EXPOSE 8080
