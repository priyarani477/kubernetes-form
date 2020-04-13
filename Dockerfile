FROM tomcat:9.0-alpine
ADD target/SpringWebmvcForm.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["docker run -p 8080:8002 SpringWebmvcForm","catalina.sh", "run"]
