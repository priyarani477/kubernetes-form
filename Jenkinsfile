pipeline {
    agent any

    stages {
        stage('One') {
            steps {
                echo 'Hi, This is Prakhar..'
            }
        }
        stage('Two') {
            steps {
                input('Do you want to proceed?')
            }
        }
        stage('Three') {
            when{
                not{
                    branch "master"
                }

            }

            steps {
                echo 'Hello...'
            }
        }
        stage('build && SonarQube analysis'){
            steps{
                withSonarQubeEnv('Sonar'){
                      bat 'mvn clean package sonar:Sonar'
                }
            }
        }
        
    }
}
