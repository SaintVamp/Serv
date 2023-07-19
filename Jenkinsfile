pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk17.0.8'
    }
    stages {
        stage('a') {
            steps {
                sh "java -version"
                sh "mvn -v"
                echo "________________________"
                echo "++++++++++++++"

                sh "mvn package"
            }
        }

        stage('b') {
            steps {
                echo "Hello World111"
            }
        }

        stage('c') {
            steps {
                sleep 1
            }
        }
        stage('通知邮件') {
            steps {
                emailext body: '$DEFAULT_CONTENT', recipientProviders: [[$class: 'RequesterRecipientProvider']], subject: '$DEFAULT_SUBJECT'
            }
        }

    }
}