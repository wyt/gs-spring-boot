FROM java:8

VOLUME /tmp

ARG JAR_FILE

COPY ${JAR_FILE} app.jar
COPY ./wait-for-it.sh /wait-for-it.sh
COPY ./startup.sh /startup.sh

RUN chmod -R 755 /startup.sh \
    && chmod a+x /startup.sh \
    && chmod -R 755 /wait-for-it.sh \
    && chmod a+x /wait-for-it.sh

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]