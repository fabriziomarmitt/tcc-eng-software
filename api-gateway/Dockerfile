FROM java:8-jdk-alpine

COPY . /opt/app
WORKDIR /opt/app

RUN apk update \
    && apk add make gcc g++ python linux-headers paxctl libgcc libstdc++ gnupg bash \
    && rm -rf /var/cache/apk/*

CMD ./gradlew bootRun