#!/usr/bin/env bash

cd $PROJ_PATH/iWeb
mvn clean install

#准备ROOT.war包
cd $PROJ_PATH/iWeb/target
mv iWeb.war ROOT.war

#制作新的docker image
cd $PROJ_PATH/iWeb
docker stop iWebObj
docker rm iWebObj
docker rmi iWeb
docker build -t iWeb .

#启动docker image
docker run --name iWebObj -d -p 8111:8080 iWeb



