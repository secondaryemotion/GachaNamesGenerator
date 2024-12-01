import DatabaseManager.DatabaseRequester;

public class QualityStubRepository implements NamePartRepository{
    private String[] qualityElements = {"Super","Mega","Legendary"};

    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException{
        if (index >= this.qualityElements.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.qualityElements[index];
    }

    @Override
    public String getRandom() {
        int index = (int) (Math.random()*qualityElements.length);
        return get(index);
    }
}
