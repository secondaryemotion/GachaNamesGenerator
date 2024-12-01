import DatabaseManager.DatabaseRequester;


public class QualityRepository implements NamePartRepository{
    private final String table = "sys.qualities";
    private final String column = "quality_names";
    private DatabaseRequester requester;

    public QualityRepository(DatabaseRequester requester){
        this.requester = requester;
    }

    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException{
        throw new UnsupportedOperationException();
    }
    @Override
    public String get() {
        return requester.getRandomValueFromColumn(table,column);
    }

    @Override
    public int getElementsCount() {
        throw new UnsupportedOperationException();
    }
}
