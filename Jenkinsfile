import groovy.sql.*
import java.sql.*

node {

      stage('Build') {
            // Get some code from a GitHub repository
            git credentialsId: '4a96169d-d4a3-4e84-87e8-4c2723d619f1', url: 'https://github.com/ZygmuntJakub/isdp_3'

            // Run Maven on a Unix agent.
            sh "mvn clean install"
      }
       stage('DBCheck') {
                String driver = "org.apache.derby.jdbc.ClientDriver"
                def sql = Sql.newInstance("jdbc:derby://35.234.114.2:1527/WM","WM","WM",driver)

                 sql.close()
            }
       stage('Deploy') {
                  // Run Maven deploy.
                  sh "mvn cargo:redeploy"
                  }
}