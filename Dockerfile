FROM eclipse-temurin:17
EXPOSE 8080
COPY target/*jar authApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","authApp-0.0.1-SNAPSHOT.jar"]
