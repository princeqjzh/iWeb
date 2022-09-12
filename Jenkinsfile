pipeline{
    agent {
        label "master"
    }

    parameters {
        string(name: "branch", defaultValue: "master", description: "Git分支")
    }

    environment {
        docker_image = 'iweb'
        docker_container = 'iWebObj'
    }

    stages{
        stage("同步最新代码"){
            steps{
                sh '''
                    mkdir -p iWeb
                '''
                dir("iWeb"){
                    checkout(
                        [
                            $class: "GitSCM",
                            branches: [[name: "$params.branch"]],
                            extensions: [[$class: "CleanBeforeCheckout"]],
                            userRemoteConfigs: [[url: "git@github.com:princeqjzh/iWeb.git"]]
                        ]
                    )
                }
            }
        }

        stage("编译打包"){
            steps{
                sh '''
                    cd ${WORKSPACE}/iWeb
                    mvn clean install -Dmaven.test.skip=true
                    mv target/iWeb.war target/ROOT.war
                '''
            }
        }

        stage("清理docker环境"){
            steps{
                script{
                    try{
                        sh 'docker stop ${docker_container}'
                    }catch(exc){
                        echo '${docker_container} container is not running!'
                    }

                    try{
                        sh 'docker rm ${docker_container}'
                    }catch(exc){
                        echo '${docker_container} container does not exist!'
                    }
                    try{
                        sh 'docker rmi ${docker_image}'
                    }catch(exc){
                        echo '${docker_image} image does not exist!'
                    }
                }
            }
        }

        stage("创建新docker镜像"){
            steps{
                script{
                    try{
                        sh '''
                            cd ${WORKSPACE}/iWeb
                            docker build -t ${docker_image} .
                        '''
                    }catch(exc){
                        echo 'Make ${docker_image} docker image failed, please check the environment!'
                    }
                }
            }
        }

        stage("启动docker容器"){
            steps{
                script{
                    try{
                        sh 'docker run --name ${docker_container} -d -p 8111:8080 ${docker_image}'
                    }catch(exc){
                        echo 'Start docker image failed, please check the environment!'
                    }
                }
            }
        }

        stage("健康接口测试"){
            steps{
                sh '''
                    cd ${WORKSPACE}/iWeb
                    mvn test
                '''
            }
        }
    }

    post {
        always {
            junit (
                testResults: 'iWeb/target/surefire-reports/*.xml'
                , allowEmptyResults: true
            )
            emailext body: '$DEFAULT_CONTENT', recipientProviders: [[$class: 'RequesterRecipientProvider']], subject: '$DEFAULT_SUBJECT'
        }
    }
}