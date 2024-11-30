import DatabaseManager.DatabaseRequester;

import java.sql.SQLException;

public class QualityRepository implements NamePartRepository{
    private final String table = "sys.qualities";
    private final String column = "quality_names";

    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException{
        throw new UnsupportedOperationException();
    }
    @Override
    public String get(DatabaseRequester requester) throws SQLException {
        return requester.getRandomValueFromColumn(table,column);
    }

    @Override
    public int getElementsCount() {
        throw new UnsupportedOperationException();
    }
}
