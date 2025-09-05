pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Report') {
            steps {
                archiveArtifacts artifacts: 'reports/TestReport.html', fingerprint: true
            }
        }
    }
}