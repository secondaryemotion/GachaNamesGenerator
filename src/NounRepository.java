import DatabaseManager.DatabaseRequester;

public class NounRepository implements NamePartRepository{
    private final String table = "sys.nouns";
    private final String column = "noun_names";
    private DatabaseRequester requester;

    public NounRepository(DatabaseRequester requester){
        this.requester = requester;
    }

    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException{
        throw new UnsupportedOperationException();
    }

    @Override
    public String get()  {
        return requester.getRandomValueFromColumn(table,column);
    }

    @Override
    public int getElementsCount() {
        throw new UnsupportedOperationException();
    }
}
