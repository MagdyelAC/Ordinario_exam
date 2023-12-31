FROM eclipse-temurin:11
RUN mkdir /opt/app
WORKDIR /opt/app
ARG JAR_FILE=target/Ordinario-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
