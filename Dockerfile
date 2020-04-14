FROM tomcat:8.5-alpine
ADD target/SpringWebmvcForm.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["docker run -p 80:8080 SpringWebmvcForm","catalina.sh", "run"]
