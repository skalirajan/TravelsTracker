pipeline {
  agent {
    node {
      label 'n1'
    }

  }
  stages {
    stage('build') {
      steps {
        build(job: 'p1', propagate: true, quietPeriod: 1, wait: true)
      }
    }

  }
  environment {
    destinationRepositoryName = 'notifications'
  }
}