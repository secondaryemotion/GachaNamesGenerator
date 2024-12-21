package NameGenerator;

import NameGenerator.DatabaseManager.DatabaseRequester;

public class NounRepository implements NamePartRepository{
    private final String table = "sys.nouns";
    private final String column = "noun_names";
    private final DatabaseRequester requester;

    public NounRepository(DatabaseRequester requester){
        this.requester = requester;
        createTableIfNotExists();
    }

    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException{
        throw new UnsupportedOperationException();
    }

    @Override
    public String getRandom()  {
        return requester.getRandomValueFromColumn(table,column);
    }

    public String[] getAllValues(){
        return requester.getAllValuesFromColumn(table,column);
    }

        @Override
    public void createTableIfNotExists() {
        requester.createNewTable(table,column);
    }

    @Override
    public void addValue(String value){
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
