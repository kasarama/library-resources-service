pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                sh 'echo hello'
            }
        }
        stage('Test'){
            steps {
                sh 'echo check'
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo publish'
            }
        }
    }
}