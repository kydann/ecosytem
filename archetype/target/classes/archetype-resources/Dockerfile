FROM java:8-jre
MAINTAINER Equipo de Anzen Soluciones <mcoronel@anzen.com.mx>

ADD ./target/${artifactId}.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/${artifactId}.jar"]

EXPOSE 5000
