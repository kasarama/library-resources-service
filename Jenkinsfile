pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'echo hello'
      }
    }

    stage('Test') {
      steps {
        sh 'echo new test'
      }
    }

    stage('Deploy') {
      steps {
        sh 'echo publish'
      }
    }

  }
  options {
    skipStagesAfterUnstable()
  }
}