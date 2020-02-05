import groovy.sql.Sql
import java.sql.*


def check() {

    DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());

    def  driver = "org.apache.derby.jdbc.ClientDriver"
    def sql = Sql.newInstance("jdbc:derby://35.234.114.2:1527/WM","WM","WM",driver)
    sql.close()
}

return this