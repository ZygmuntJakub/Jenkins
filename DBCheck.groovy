import groovy.sql.Sql

@GrabConfig(systemClassLoader=true)
@Grab(group='org.apache.derby', module='derbyclient', version='10.14.2.0')
def check() {
    def  driver = "org.apache.derby.jdbc.ClientDriver"
    def sql = Sql.newInstance("jdbc:derby://35.234.114.2:1527/WM","WM","WM",driver)
    sql.close()
}

return this