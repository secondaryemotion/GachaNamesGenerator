import DatabaseManager.DatabaseRequester;


public class QualityRepository implements NamePartRepository{
    private final String table = "sys.qualities";
    private final String column = "quality_names";
    private final DatabaseRequester requester;

    public QualityRepository(DatabaseRequester requester){
        this.requester = requester;
    }

    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException{
        throw new UnsupportedOperationException();
    }
    @Override
    public String getRandom() {
        return requester.getRandomValueFromColumn(table,column);
    }

}
