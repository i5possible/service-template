FROM openjdk:11-jdk

ENV PORT 8080
EXPOSE $PORT

WORKDIR /app
COPY image/run ./
COPY image/newrelic.yml ./
COPY build/libs/service-template.jar app.jar
COPY build/libs/newrelic.jar ./

RUN adduser --disabled-password --gecos user password
RUN chmod -R go-w *
USER user

ENTRYPOINT ["/bin/bash", "-c", "./run"]
