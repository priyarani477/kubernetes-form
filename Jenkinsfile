pipeline{
   agent any
tools{
     jdk 'jdk1.8'
     maven 'maven3.6'
}

 
   stages {
  
  
      
              stage("Code Checkout") {
                                steps {
                                       git url: 'https://github.com/prakharbh4/jenkins.git'
                                      }
                                     }
              stage('Build Stage') {
                               steps{
                                        bat 'mvn -version'
                                     }
                                    }
              stage('Compile Stage'){
                                steps{
                                       bat 'mvn clean install'
                                      }
                                     }
              stage('Testing Stage'){
                                steps{
                                      bat 'mvn test'
                                     } 
                                    }
              stage('build && SonarQube analysis'){
                                steps {
                                       withSonarQubeEnv('sonar') {
                                                                     bat 'mvn clean package sonar:sonar'
                                                                 } 
                                      } 
                                    }
      stage('Deploy to tomcat'){
                                steps{
                                       bat "copy target\\SpringWebmvcForm.war\ 'C:\\Users\\prakharbhatia\\apache-tomcat-9.0.31\\webapps\'"
                                     }
                                   }
              stage('Deploy artifact'){
                                steps{
                                      rtServer (id: 'artifactory',url: 'http://localhost:8081/artifactory',username: 'admin',password: 'admin')
                                      rtUpload (serverId: 'artifactory',spec: '''{"files": [{ "pattern": "/**.war","target": "maven_artifact/"}]}''')
                                      }
                                     }
              
                                 }
}
