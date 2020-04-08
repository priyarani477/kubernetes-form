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
                withSonarQubeEnv('SonarQube'){
                      bat 'mvn clean package sonar:sonar'
                }
            }
        }
        stage('Deploy artifact')
             {
                 steps{
                     rtServer (
                         id: 'artifactory',
                         url: 'http://localhost:8081/artifactory',
                         username: 'admin',
                         password: 'password'
                     )
                     rtUpload (
                         serverId: 'artifactory',
                         spec: '''{
                         "files": [
                              { "pattern": "/**.war",
                                "target": "SpringWebmvcForm"
                              }
                           ]
                         }'''
                     )
                 }
             }
        
    }
}
