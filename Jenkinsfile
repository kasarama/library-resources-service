pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'echo new one'
      }
    }

    stage('Test') {
      steps {
        sh 'echo new two'
      }
    }

    stage('Deploy') {
      steps {
        sh 'echo new three'
      }
    }

  }
  options {
    skipStagesAfterUnstable()
  }
}