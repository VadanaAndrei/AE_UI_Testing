pipeline {
    agent any

    tools {
        jdk 'jdk24'
        maven 'maven3.9.11'
        allure 'allure2.35.1'
    }

    triggers {
            cron('0 12 * * *')
        }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
            always {
                junit 'target/surefire-reports/*.xml'

                allure includeProperties: false,
                       jdk: '',
                       report: 'allure-report',
                       results: [[path: 'target/allure-results']]
            }

            success {
                emailext (
                    subject: "SUCCES: Build ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: "Build Success",
                    to: "avadana@griddynamics.com"
                )
            }

            failure {
                emailext (
                    subject: "EȘEC: Build ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: "Build Failed",
                    to: "avadana@griddynamics.com"
                )
            }
        }
    }
}