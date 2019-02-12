FROM java:8-jre
MAINTAINER Equipo de Anzen Soluciones <mcoronel@anzen.com.mx>

ADD ./target/admin.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/admin.jar"]

EXPOSE 5000
