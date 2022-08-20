FROM java:8u111

VOLUME /tmp

ADD target/demo-0.0.1-SNAPSHOT.jar demo.jar

EXPOSE 80

ENTRYPOINT ["java","-jar","/demo.jar"]

# Ubuntu 时区
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime