FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY ./   /
COPY /src/main/resources/Orders-Gridview.csv /Orders-Gridview.csv
ENTRYPOINT ["java","-Dspring.profiles.active=test","-jar","/app.jar"]
