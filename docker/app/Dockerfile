FROM openjdk:jdk-alpine

VOLUME /tmp

RUN mkdir /jar

COPY . /jar

WORKDIR /jar

ENTRYPOINT ["java", "-jar", "torimo-core-0.1.jar"]