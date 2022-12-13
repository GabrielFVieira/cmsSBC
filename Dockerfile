FROM openjdk:8
ADD target/cmsSBC.jar cmsSBC.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "cmsSBC.jar"]