FROM openjdk:jdk-alpine

VOLUME /tmp

RUN mkdir /jar

COPY . /jar

WORKDIR /jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=production", "torimo-search-1.jar"]
