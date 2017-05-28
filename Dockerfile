FROM openjdk:8
EXPOSE 8080 8888
RUN pwd
RUN mkdir shardool
RUN ls
RUN curl http://172.17.0.11/programme.jar -o /shardool/programme.jar
CMD java -jar /shardool/programme.jar
