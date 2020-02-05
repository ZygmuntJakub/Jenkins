pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "M3"
   }

   stages {
      stage('Build') {
         steps {
            // Get some code from a GitHub repository
            git credentialsId: '4a96169d-d4a3-4e84-87e8-4c2723d619f1', url: 'https://github.com/ZygmuntJakub/isdp_3'

            // Run Maven on a Unix agent.
            sh "mvn clean install"
         }
      }
            stage('Deploy') {
               steps {

                  // Run Maven deploy.
                  sh "mvn cargo:deploy"
               }
            }
   }
}