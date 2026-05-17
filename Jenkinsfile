pipeline {
    agent any

    tools {
        maven 'Maven-3.9'
        jdk 'java'
    }

    environment {
        DOCKER_USERNAME = "bien18"
        IMAGE_NAME = "bien18/triangle-app:${BUILD_NUMBER}"
    }

    stages {

        stage('Git Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'git_credentials',
                    url: 'https://github.com/FANOMEZANTSOA-Bien-Aime-Louison/jenkins-dockerhub-pipeline.git'
            }
        }

        stage('Build Application') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t %IMAGE_NAME% ."
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([string(credentialsId: 'dockerhubpass', variable: 'DOCKER_PASS')]) {
                    bat """
                        docker login -u %DOCKER_USERNAME% -p %DOCKER_PASS%
                        docker push %IMAGE_NAME%
                    """
                }
            }
        }
    }

    post {

        success {
            mail to: 'hnlouison@gmail.com',
                subject: "✅ SUCCESS: Build ${BUILD_NUMBER}",
                body: """
                            Le build ${BUILD_NUMBER} a réussi ✅

                            Projet: ${JOB_NAME}
                            Image Docker: ${IMAGE_NAME}
                    """
        }

        failure {
            mail to: 'hnlouison@gmail.com',
                subject: "❌ FAILURE: Build ${BUILD_NUMBER}",
                body: """
                            Le build ${BUILD_NUMBER} a échoué ❌

                            Projet: ${JOB_NAME}
                            Vérifiez Jenkins pour voir l’erreur.
                        """
        }
    }
}