package DatabaseManager;

import java.sql.*;

public class DatabaseRequester {
    public Connection connection;
    private String query = "SELECT * FROM %s ORDER BY RAND() LIMIT 1";
    public DatabaseRequester(){

        this.connection = DatabaseConnection.getConnection();
    }

    public String getRandomValueFromColumn(String table, String column) {
        try {
            Statement statement = connection.createStatement();
            ResultSet randomValue = statement.executeQuery(String.format(query,table));
            randomValue.next();

            return randomValue.getString(column);
        } catch (SQLException e){
            throw new RuntimeException("unhandled",e);
        }

    }
}
