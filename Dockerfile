FROM openjdk:17-jdk-slim
COPY target/traffic-0.0.1-SNAPSHOT.jar traffic-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "traffic-0.0.1-SNAPSHOT.jar"]
EXPOSE 8092