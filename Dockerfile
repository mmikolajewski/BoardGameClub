FROM eclipse-temurin:17-jdk
EXPOSE 8080
RUN mkdir -p /uploads/files/
RUN mkdir -p /uploads/img/
COPY target/project-*.jar /app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod,docker","-jar","/app.jar"]
