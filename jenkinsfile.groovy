stage('源码下载') {
    node('slave'){
        git([url: 'git@github.com:princeqjzh/iWeb.git', branch: 'master'])
    }
}

stage('maven编译打包') {
    node('slave'){
        sh ". /etc/profile"
        sh ". ~/.bash_profile"

        //定义maven java环境
        def mvnHome = tool 'maven-3.3.3_slave'
        def jdkHome = tool 'jdk1.8_slave'
        env.PATH = "${mvnHome}/bin:${env.PATH}"
        env.PATH = "${jdkHome}/bin:${env.PATH}"
        sh "mvn clean install"
        sh "mv target/iWeb.war target/ROOT.war"
    }
}

stage('清理docker环境') {
    node('slave'){
        try{
            sh 'docker stop iWebObj'
        }catch(exc){
            echo 'iWebObj实例没有运行'
        }

        try{
            sh 'docker rm iWebObj'
        }catch(exc){
            echo 'iWebObj实例不存在'
        }
        try{
            sh 'docker rmi iweb'
        }catch(exc){
            echo 'iweb 镜像不存在'
        }
    }
}

stage('生成新的镜像') {
    node('slave'){
        try{
            sh 'docker build -t iweb .'
        }catch(exc){
            echo '镜像iweb生成失败，请去运行时环境检查！'
        }
    }
}

stage('启动docker镜像') {
    node('slave'){
        try{
            sh 'docker run --name iWebObj -d -p 8111:8080 iweb'
        }catch(exc){
            echo 'docker 实例启动失败，请去运行时环境检查！'
        }
    }
}