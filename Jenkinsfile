pipeline {
    agent any

    tools {
        jdk 'JDK_25'
        maven 'Maven_3_9_11'
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