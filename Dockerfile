FROM openjdk:8-jdk-alpine
ENV JAVA_OPTS="-Duser.timezone=Asia/Shanghai -Xms256m -Xmx512m"
ENV PARAMS=""
COPY DIST_JAR_PATH /Users/hudeshun/Downloads/DIST_JAR_NAME
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /Users/hudeshun/Downloads/DIST_JAR_NAME $PARAMS"]
EXPOSE PROJECT_PORT

