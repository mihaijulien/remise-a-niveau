#Start with a base image containing Java runtime
FROM amazoncorretto:21-alpine-jdk

#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="mihaijulien"

# Add the application's jar to the image
COPY target/departement-microservice-0.0.1-SNAPSHOT.jar departement-microservice-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java", "-jar", "departement-microservice-0.0.1-SNAPSHOT.jar"]