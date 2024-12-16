package NameGenerator;

public class ColorStubRepository implements NamePartRepository{
    private final String[] colorElements = {"Red", "Blue","Violet"};


    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException{
        if (index >= this.colorElements.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.colorElements[index];
    }

    @Override
    public String getRandom() {
        int index = (int) (Math.random()*colorElements.length-1);
        return get(index);
    }

    @Override
    public String[] getAllValues(){
        return colorElements;
    }

    @Override
    public void createTableIfNotExists(){
       throw new UnsupportedOperationException();
    }

    @Override
    public void addValueToTable(String value){
       throw new UnsupportedOperationException();
    }

    @Override
    public void updateValue(String oldValue, String newValue){
       throw new UnsupportedOperationException();
    }

    @Override
    public void deleteValue(String value){
       throw new UnsupportedOperationException();
    }


}
