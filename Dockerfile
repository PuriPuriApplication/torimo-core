FROM openjdk:jdk-alpine

VOLUME /tmp
RUN mkdir /app
COPY . /app
WORKDIR /app

RUN ./gradlew build
WORKDIR /build/libs
ENTRYPOINT ["java", "-jar", "torimo-core-0.1.jar"]
