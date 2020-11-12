FROM openjdk:11-jdk

ENV PORT 8080
EXPOSE $PORT

WORKDIR /app
COPY docker/run ./
COPY docker/newrelic.yml ./
COPY build/libs/service-template.jar app.jar
COPY build/libs/newrelic.jar ./

RUN adduser --disabled-password --gecos service-template service-template
RUN chmod -R go-w *
USER service-template

ENTRYPOINT ["/bin/bash", "-c", "./run"]
