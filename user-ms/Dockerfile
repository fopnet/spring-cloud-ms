FROM openjdk:11
VOLUME /tmp
ADD ./target/user-0.0.1-SNAPSHOT.jar ms-user-server.jar
ENTRYPOINT ["java","-jar","/ms-user-server.jar"]