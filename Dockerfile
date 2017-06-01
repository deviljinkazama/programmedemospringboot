FROM openjdk:7
EXPOSE 8080 8888
RUN pwd
RUN mkdir shardool
RUN ls
RUN echo Change@11-28PM
RUN curl http://172.17.0.11/programme-${NUMBER}.jar -o /shardool/programme-${NUMBER}.jar
CMD java -jar /shardool/programme-${NUMBER}.jar
