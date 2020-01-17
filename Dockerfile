FROM openjdk:8-jdk-alpine

ENV TZ=America/Recife

COPY ./target/cartorio-0.0.1-SNAPSHOT.jar cartorio.jar

CMD ["java","-jar", "cartorio.jar"]