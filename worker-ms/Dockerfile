FROM openjdk:11
VOLUME /tmp
ADD ./target/worker-0.0.1-SNAPSHOT.jar ms-worker-server.jar
ENTRYPOINT ["java","-jar","/ms-worker-server.jar"]