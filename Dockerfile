FROM openjdk:12
ADD target/atm-service-0.0.1-SNAPSHOT.jar atm-service-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "atm-service-0.0.1-SNAPSHOT.jar"]