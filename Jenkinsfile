pipeline {
    agent any
        stages {
            stage('Pull') {
                steps {
                    git credentialsId: '4a96169d-d4a3-4e84-87e8-4c2723d619f1', url: 'https://github.com/ZygmuntJakub/isdp_3'
                }
            }
            stage('Build') {
                steps {
                    sh "mvn clean package"
                }
            }
            stage('DBCheck') {
                steps {
                    sh "mvn compile exec:java -Dexec.mainClass=\"DBCheck\" -f ~/DBCheckTest/pom.xml"
                }
            }
            stage('Tests'){
                steps{
                    sh "mvn clean test -f ~/selenium/pom.xml"
               }
            }
            stage('Deploy'){
                steps {
                    sh "mvn cargo:redeploy"
                }
            }
            stage('Tests'){
                steps{
                    sh "mvn clean test -f ~/selenium/pom.xml"
                }
            }
        }
}