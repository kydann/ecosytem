FROM java:8-jre
MAINTAINER Equipo de Anzen Soluciones <mcoronel@anzen.com.mx>

ADD ./target/jdbc-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/jdbc-server.jar"]

EXPOSE 8888
