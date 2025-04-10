package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {

    private static final String fileName = "src/db.properties";

    public static Connection getDbConnection() {
        Connection con = null;
        String connString = null;


        try {
            connString = DBPropertyUtil.getConnectionString(fileName);
        } catch (IOException e) {
            System.out.println("Connection string could not be retrieved.");
            e.printStackTrace();
        }

        if (connString != null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(connString); 
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Database connection failed.");
                e.printStackTrace();
            }
        }

        return con;
    }
}
