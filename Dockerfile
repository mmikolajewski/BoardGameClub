FROM maven:3.9.4-eclipse-temurin-17 AS MAVEN_BUILD
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY ./src ./src
RUN mvn package

FROM eclipse-temurin:17-jdk
EXPOSE 8080
RUN mkdir -p /uploads/files/
RUN mkdir -p /uploads/img/
COPY --from=MAVEN_BUILD /target/project-*.jar /app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod,docker","-jar","/app.jar"]
