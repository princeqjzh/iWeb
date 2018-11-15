FROM tomcat:latest
MAINTAINER tester "tester@hogwarts.com"
RUN rm -rf /usr/local/tomcat/webapps/ROOT
RUN rm -f /usr/local/tomcat/webapps/ROOT.war
ADD target/ROOT.war /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["/usr/local/tomcat/bin/catalina.sh","run"]