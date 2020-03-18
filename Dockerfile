FROM openjdk:8
ADD target/aau-java.jar aau-java.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "aau-java.jar"]