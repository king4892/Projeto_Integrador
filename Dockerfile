FROM openjdk:13
EXPOSE 8080
ARG JAR_FILE=target/projetobasico-0.0.1-SNAPSHOT.jar projetobasico-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]