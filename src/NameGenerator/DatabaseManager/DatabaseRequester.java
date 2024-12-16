package NameGenerator.DatabaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseRequester {
    public Connection connection;

    public DatabaseRequester(){

        this.connection = DatabaseConnection.getConnection();
    }

    public String getRandomValueFromColumn(String table, String column) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM %s ORDER BY RAND() LIMIT 1";
            ResultSet randomValue = statement.executeQuery(String.format(query,table));
            randomValue.next();

            return randomValue.getString(column);
        } catch (SQLException e){
            throw new RuntimeException("unhandled",e);
        }

    }

    public String[] getAllValuesFromColumn(String table, String column){
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM %s";
            int rowsCount =  getValuesCountFromTable(table);
            String[] result = new String[rowsCount];
            ResultSet value = statement.executeQuery(String.format(query,table));
            int i = 0;
            while (value.next()){
                result[i] = value.getString(column);
                i++;
            }

            return result;
        } catch (SQLException e){
            throw new RuntimeException("unhandled",e);
        }
    }

    public int getValuesCountFromTable(String table){
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT COUNT(*) AS total FROM %s";
            ResultSet countResult = statement.executeQuery(String.format(query,table));
            countResult.next();

            return countResult.getInt("total");
        } catch (SQLException e){
            throw new RuntimeException("unhandled",e);
        }
    }

    public void createValueInColumn(String table, String column, String value){
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO %s (%s) VALUE (%s)";
            statement.executeQuery(String.format(query,table,column,value));

        } catch (SQLException e){
            throw new RuntimeException("unhandled",e);
        }
    }

    public void updateValueInColumn(String table, String column, String oldValue, String newValue){
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE %s SET %s = (%s) WHERE %s = (%s)";
            statement.executeQuery(String.format(query,table,column,oldValue,column,newValue));
        } catch (SQLException e){
            throw new RuntimeException("unhandled",e);
        }
    }

    public void deleteValueInColumn(String table, String column, String value){
        try {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM %s WHERE %s = (%s)";
            statement.executeQuery(String.format(query,table,column,value));
        } catch (SQLException e){
            throw new RuntimeException("unhandled",e);
        }
    }

    public void createNewTable(String table, String column){
        if (!isTableExists(table)) {
            try {
                Statement statement = connection.createStatement();
                String query = "CREATE TABLE %s (id INT NOT NULL AUTO_INCREMENT," +
                        "%s VARCHAR(45) NOT NULL," +
                        "PRIMARY KEY (id), " +
                        "UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE)";
                statement.execute(String.format(query,table,column));
            } catch (SQLException e){
                throw new RuntimeException("unhandled",e);
        }
        }
    }

    public boolean isTableExists(String table){
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT COUNT(*) AS total FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '%s' AND  TABLE_NAME = '%s'";
            ResultSet result = statement.executeQuery(String.format(query,table.split("\\.")[0],table.split("\\.")[1]));
            result.next();
            return result.getInt("total") > 0;
        } catch (SQLException e){
            throw new RuntimeException("unhandled",e);
        }
    }

}
