FROM  openjdk:17.0.1-jdk-slim

ADD target/library-service-0.0.1-SNAPSHOT*.jar ./library-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","library-service-0.0.1-SNAPSHOT.jar"]