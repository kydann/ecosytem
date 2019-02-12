FROM java:8-jre
MAINTAINER Equipo de Anzen Soluciones <mcoronel@anzen.com.mx>

ADD ./target/gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/gateway.jar"]

EXPOSE 8080
