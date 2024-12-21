package NameGenerator;

public class QualityStubRepository implements NamePartRepository{
    private final String[] qualityElements = {"Super","Mega","Legendary"};

    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException{
        if (index >= this.qualityElements.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.qualityElements[index];
    }

    @Override
    public String getRandom() {
        int index = (int) (Math.random()*qualityElements.length-1);
        return get(index);
    }

    @Override
    public String[] getAllValues(){
        return qualityElements;
    }

    @Override
    public void createTableIfNotExists(){
       throw new UnsupportedOperationException();
    }

    @Override
    public void addValue(String value){
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
