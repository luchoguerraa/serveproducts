FROM openjdk:11
ARG JAR_FILE=build/libs/serveproducts-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} serverproducts.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/serverproducts.jar"]