FROM openjdk:8-jdk-alpine
# time zone
ENV TIME_ZONE Asia/Shanghai
RUN apk add --no-cache tzdata                 #有些容器里没有/usr/share/zoneinfo目录
RUN echo "${TIME_ZONE}" > /etc/timezone
RUN ln -sf /usr/share/zoneinfo/${TIME_ZONE} /etc/localtime
VOLUME /tmp
ADD user-1.0-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Xms80m", "-Xmx512m","-jar","app.jar"]
