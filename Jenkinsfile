pipeline{ environment {
    registry = "prakharbhatia4/prakhar"
    registryCredential = 'docker'
  }  
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
        stage('Deploy artifact'){
                                steps{
                                     bat 'mvn deploy'
                                      }
                                     }   
      
      
       stage('Building image') {
                                steps{
                                     script {
                                            dockerImage= docker.build registry + ":$BUILD_NUMBER"
                                            }
                                     }
                               }
  
       stage('Deploy Image') {
                              steps{
                                    script {
                                            docker.withRegistry( '', registryCredential ) {
                                            dockerImage.push()
                                           }
                                   }
                             }
       }
       stage('Deploy'){
           steps{
                 bat 'docker run -p 81:8080 prakharbhatia4/prakhar:%BUILD_NUMBER%'
           }
       }
          stage('Deploy to tomcat'){
                                steps{
                                       bat "copy target\\SpringWebmvcForm.war \"C:\\Users\\prakharbhatia\\apache-tomcat-9.0.31\\webapps\""
                                     }
                                   }
            
              
  }
}

