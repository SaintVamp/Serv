pipeline {
    agent any
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

    }
}