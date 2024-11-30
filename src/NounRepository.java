import DatabaseManager.DatabaseRequester;

import java.sql.SQLException;

public class NounRepository implements NamePartRepository{
    private final String table = "sys.nouns";
    private final String column = "noun_names";

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
