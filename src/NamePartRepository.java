import DatabaseManager.DatabaseRequester;

import java.sql.SQLException;

public interface NamePartRepository {
     String get(int index) throws ArrayIndexOutOfBoundsException;
     String get() throws SQLException;
     int getElementsCount();
}
