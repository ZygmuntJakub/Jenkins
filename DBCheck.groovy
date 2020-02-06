import groovy.sql.Sql

def check() {

    def  driver = "org.apache.derby.jdbc.ClientDriver"
    def sql = Sql.newInstance("jdbc:derby://35.234.114.2:1527/WM","WM","WM",driver)
    sql.close()
}

return this