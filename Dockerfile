FROM gcr.io/docker-images-180022/base/openjdk:11-ubuntu

ARG REVISION

LABEL REVISION=$REVISION

RUN addgroup --gid 1000 kafka-test && \
    adduser --disabled-password --gecos "" --uid 1000 --gid 1000 kafka-test

RUN mkdir -p /app
WORKDIR /app

USER 1000

COPY . .
COPY build/libs/kafka-test.jar bin/core.jar

EXPOSE 8080

CMD ["java", "-jar", "bin/core.jar", "com/zendesk/ServiceStarter"]
