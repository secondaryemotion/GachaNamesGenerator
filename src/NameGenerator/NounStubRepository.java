package NameGenerator;

public class NounStubRepository implements NamePartRepository{
    private final String[] nounElements = {"Plasma TV","Terrifier 3000"};


    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException{
        if (index >= this.nounElements.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.nounElements[index];
    }

    @Override
    public String getRandom() {
        int index = (int) (Math.random()*nounElements.length-1);
        return get(index);
    }

    @Override
    public String[] getAllValues(){
        return nounElements;
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
