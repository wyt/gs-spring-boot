FROM java:8

VOLUME /tmp

ARG JAR_FILE

COPY ${JAR_FILE} app.jar
COPY ./wait-for-it.sh /wait-for-it.sh

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

ENTRYPOINT ["wait-for-it.sh", "db:3306", "--", "catalina.sh", "run"]