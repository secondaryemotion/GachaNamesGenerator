import java.sql.SQLException;

public interface NamePartRepository {
     String getRandom() throws SQLException;
     String get(int index) throws ArrayIndexOutOfBoundsException;
}
