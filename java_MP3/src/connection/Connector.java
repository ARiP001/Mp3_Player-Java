package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static Connection con = null;

    private static final String DB_URL = "jdbc:mysql://localhost/mp3";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection Success");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connection Failed: " + ex.getMessage());
        }
    }

    public static Connection connection() {
        return con;
    }
}
