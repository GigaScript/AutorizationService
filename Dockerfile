FROM openjdk:latest

EXPOSE 8080

ADD target/AutorizationService-0.0.1-SNAPSHOT.jar autorized-app.jar

CMD ["java", "-jar", "autorized-app.jar"]