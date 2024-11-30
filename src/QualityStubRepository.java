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

    public String get(DatabaseRequester requester) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getElementsCount() {
        return this.qualityElements.length;
    }
}
