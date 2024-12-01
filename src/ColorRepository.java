import DatabaseManager.DatabaseRequester;


public class ColorRepository implements NamePartRepository{
    private final String table = "sys.colors";
    private final String column = "color_names";
    private final DatabaseRequester requester;

    public ColorRepository(DatabaseRequester requester){
        this.requester = requester;
    }

    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getRandom() {
        return requester.getRandomValueFromColumn(table,column);
    }


}
