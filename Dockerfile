#从tomcat的镜像开始创建
FROM tomcat:latest

#声明作者
MAINTAINER tester "tester@hogwarts.com"

#清理docker镜像中已有的内容
RUN rm -rf /usr/local/tomcat/webapps/ROOT
RUN rm -f /usr/local/tomcat/webapps/ROOT.war

#将新的ROOT.war 复制到镜像中的指定位置
ADD target/ROOT.war /usr/local/tomcat/webapps

#对外暴露8080端口
EXPOSE 8080

#等于执行 catalina.sh run
CMD ["/usr/local/tomcat/bin/catalina.sh","run"]