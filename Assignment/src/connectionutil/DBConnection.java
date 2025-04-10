package connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/couriermanagement";
                String username = "root";
                String password = "cats";
                String driver = "com.mysql.cj.jdbc.Driver";

                Class.forName(driver); 
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
