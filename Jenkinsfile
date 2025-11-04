pipeline {
    agent any

    tools {
        jdk 'jdk24.0.2'
        maven 'maven3.9.11'
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
    }
}