FROM openjdk:8
COPY *.jar app.jar
CMD ["java", "-jar", "app.jar"]
