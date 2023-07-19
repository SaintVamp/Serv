pipeline {
    agent any
    stages {
        stage('a') {
            steps {
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

    }
}