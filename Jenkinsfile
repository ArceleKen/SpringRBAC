pipeline {
    agent any
    stages {
        stage('Build'){
            steps {
                echo 'Build en cours ...'
                sh('chmod +x ./ecrire.sh')
                sh ('./ecrire.sh')
            }
        }
        stage('Test'){
            steps {
                echo 'Test en cours ...'
            }
        }
        stage('Release'){
            steps {
                echo 'Release en cours ...'
                sh ("${env.WORKSPACE}/ecrire.sh")
            }
        }
        stage('Deploy'){
            steps {
                echo 'Deploy en cours ...'
                dir("${env.WORKSPACE}") {
                    sh ('./ecrire.sh')
                }
            }
        }
    }
}
