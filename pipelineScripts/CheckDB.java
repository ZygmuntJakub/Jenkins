import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import org.apache.derby.jdbc.*;

public class CheckDB {
    public static void main(String[] args) throws SQLException {
        String dbURL = "jdbc:derby://10.156.0.3:1527/WM";
        String dbCreateURL = "jdbc:derby://10.156.0.3:1527/WM;create=true";
        String user = "WM";
        String password = "WM";



        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("Trying to access DB...");

        DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());

        try(Connection conn = DriverManager.getConnection(dbURL, user, password)){
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println("Could not access DB. Attempting to create one...");
            try(Connection conn = DriverManager.getConnection(dbCreateURL, user, password)){
                System.out.println("New DB created successfully");
            }

        }
    }
}
