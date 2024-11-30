import DatabaseManager.DatabaseRequester;

import java.sql.SQLException;

public interface NamePartRepository {
     String get(int index) throws ArrayIndexOutOfBoundsException;
     String get(DatabaseRequester requester) throws SQLException;
     int getElementsCount();
}
