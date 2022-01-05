FROM openjdk:11
VOLUME /tmp
ADD ./target/payroll-0.0.1-SNAPSHOT.jar ms-payroll-server.jar
ENTRYPOINT ["java","-jar","/ms-payroll-server.jar"]