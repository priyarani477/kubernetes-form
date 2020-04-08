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
        stage('SonarQube analysis'){
            steps{
                withSonarQubeEnv('Sonar'){
                      bat 'mvn sonar:sonar -Dsonar.projectKey=Sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=22016bc72c7959a3d175bb5058597b14ba667095'
                }
            }
        }
        
    }
}
