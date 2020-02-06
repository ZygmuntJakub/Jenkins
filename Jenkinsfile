def dbScript
import java.sql.SQLException;

node {

      stage('Build') {
            // Get some code from a GitHub repository
            git credentialsId: '4a96169d-d4a3-4e84-87e8-4c2723d619f1', url: 'https://github.com/ZygmuntJakub/isdp_3'

            // Run Maven on a Unix agent.
            sh "mvn clean install"
      }
       stage('DBCheck') {
                // Try to connect with database using prepared java script

				// sh "javac ./pipelineScripts/CheckDB.java"
				// sh "java -cp /opt/Apache/db-derby-10.14.2.0-bin/lib/derbytools.jar:/opt/Apache/db-derby-10.14.2.0-bin/lib/derbyclient.jar:./pipelineScripts CheckDB"

				GIT_COMMIT_EMAIL = sh (
                    script: 'java -cp /opt/Apache/db-derby-10.14.2.0-bin/lib/derbytools.jar org.apache.derby.tools.ij',
                    returnStdout: true
                ).trim()

                System.out.println('Tutaj powinna byc wartosc:' + ${GIT_COMMIT_EMAIL});
            }
       stage('Deploy') {
                  // Run Maven deploy.
                  sh "mvn cargo:redeploy"
                  }
}