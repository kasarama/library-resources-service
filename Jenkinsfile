pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'echo new hello'
      }
    }

    stage('Test') {
      steps {
        sh 'echo new test'
      }
    }

    stage('Deploy') {
      steps {
        sh 'echo new publish'
      }
    }

  }
  options {
    skipStagesAfterUnstable()
  }
}