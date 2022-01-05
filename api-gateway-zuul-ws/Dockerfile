FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/api-gateway-zuul-ws-0.0.1-SNAPSHOT.jar api-gateway-zuul.jar
ENTRYPOINT ["java","-jar","/api-gateway-zuul.jar"]