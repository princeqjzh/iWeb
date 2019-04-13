stage('pull source code') {
    node('master'){
        git([url: 'git@github.com:princeqjzh/iWeb.git', branch: 'master'])
    }
}

stage('maven compile & package') {
    node('master'){
        sh ". /etc/profile"
        sh ". ~/.bash_profile"

        //定义maven java环境
        def mvnHome = tool 'maven-3.6.0_master'
        def jdkHome = tool 'jdk1.8_master'
        env.PATH = "${mvnHome}/bin:${env.PATH}"
        env.PATH = "${jdkHome}/bin:${env.PATH}"
        sh "mvn clean install"
        sh "mv target/iWeb.war target/ROOT.war"
    }
}

stage('clean docker environment') {
    node('master'){
        try{
            sh 'docker stop iWebObj'
        }catch(exc){
            echo 'iWebObj container is not running!'
        }

        try{
            sh 'docker rm iWebObj'
        }catch(exc){
            echo 'iWebObj container does not exist!'
        }
        try{
            sh 'docker rmi iweb'
        }catch(exc){
            echo 'iweb image does not exist!'
        }
    }
}

stage('make new docker image') {
    node('master'){
        try{
            sh 'docker build -t iweb .'
        }catch(exc){
            echo 'Make iweb docker image failed, please check the environment!'
        }
    }
}

stage('start docker container') {
    node('master'){
        try{
            sh 'docker run --name iWebObj -d -p 8111:8080 iweb'
        }catch(exc){
            echo 'Start docker image failed, please check the environment!'
        }
    }
}