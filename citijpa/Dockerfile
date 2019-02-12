FROM java:8-jre
MAINTAINER Equipo de Anzen Soluciones <mcoronel@anzen.com.mx>

ADD ./target/citijpa.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/citijpa.jar"]

EXPOSE 5000
