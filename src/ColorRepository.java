import DatabaseManager.DatabaseRequester;


public class ColorRepository implements NamePartRepository{
    private final String table = "sys.colors";
    private final String column = "color_names";
    private final DatabaseRequester requester;

    public ColorRepository(DatabaseRequester requester){
        this.requester = requester;
        this.createTableIfNotExists();
    }

    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getRandom() {
        return requester.getRandomValueFromColumn(table,column);
    }

    @Override
    public String[] getAllValues(){
        return requester.getAllValuesFromColumn(table,column);
    }

    @Override
    public void createTableIfNotExists() {
        requester.createNewTable(table,column);
    }

    @Override
    public void addValueToTable(String value){
        requester.createValueInColumn(table,column,value);
    }

    @Override
    public void updateValue(String oldValue, String newValue){
        requester.updateValueInColumn(table,column,oldValue,newValue);
    }

    @Override
    public void deleteValue(String value){
        requester.deleteValueInColumn(table,column,value);
    }


}
