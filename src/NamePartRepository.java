import java.sql.SQLException;

public interface NamePartRepository {
     String getRandom() throws SQLException;
     String get(int index) throws ArrayIndexOutOfBoundsException;
     String[] getAllValues();
     void createTableIfNotExists();
     void addValueToTable(String value);
     void updateValue(String oldValue, String newValue);
     void deleteValue(String value);
}
