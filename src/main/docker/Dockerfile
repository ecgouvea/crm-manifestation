FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD crm-manifestation-0.0.1-SNAPSHOT.jar crm-manifestation.jar
RUN sh -c 'touch /crm-manifestation.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /crm-manifestation.jar" ]