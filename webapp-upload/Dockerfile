ARG JDK_VERSION=18-oraclelinux8

FROM openjdk:${JDK_VERSION}
LABEL maintainer="Dimas Maryanto <software.dimas_m@icloud.com>"
WORKDIR /usr/share/apps/

ARG JAR_FILE="nke-webapp-upload.jar"
# copy file from local to images then rename to spring-boot.jar
ADD target/$JAR_FILE spring-boot.jar

ENV APPLICATION_PORT=8080
ENV FILE_UPLOAD_DIR=/var/data/upload

RUN mkdir -p $FILE_UPLOAD_DIR && \
    chmod -R 777 $FILE_UPLOAD_DIR

# reqired command to run application
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "spring-boot.jar"]
CMD ["--server.port", "$APPLICATION_PORT"]