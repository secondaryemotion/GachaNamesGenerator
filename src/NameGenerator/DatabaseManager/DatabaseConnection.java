package NameGenerator.DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static Connection connection;

    static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);

            return connection;
        } catch (SQLException e){
            throw new RuntimeException("unhandled",e);
        }
    }
}
