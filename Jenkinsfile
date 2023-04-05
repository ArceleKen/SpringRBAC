
pipeline {
  agent any 
  stages {
    stage('Build'){
      steps {
        echo 'Build un cours...'
        sh('chmod +x ./ecrire.sh')
        sh('./ecrire.sh')
      }
    }
    stage('Test'){
      steps {
        echo 'Test un cours...'
      }
    }
    stage('Release'){
      steps {
        echo 'Release un cours...'
        sh("$(env.WORKSPACE)/ecrire.sh")
      }
    }
    stage('Deploy'){
      steps {
        echo 'Deploy un cours...'
        dir("$(env.WORKSPACE)") {
          sh('./ecrire.sh')
        }
      }
    }
  }
}
