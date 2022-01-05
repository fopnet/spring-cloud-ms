FROM openjdk:11
VOLUME /tmp
ADD ./target/ms-auth-0.0.1-SNAPSHOT.jar ms-auth-server.jar
ENTRYPOINT ["java","-jar","/ms-auth-server.jar"]