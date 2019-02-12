FROM java:8-jre
MAINTAINER Equipo de Anzen Soluciones <mcoronel@anzen.com.mx>

ADD ./target/citi.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/citi.jar"]

EXPOSE 5000
