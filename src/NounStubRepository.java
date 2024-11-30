import DatabaseManager.DatabaseRequester;


public class NounStubRepository implements NamePartRepository{
    private String[] nounElements = {"Plasma TV","Terrifier 3000"};


    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException{
        if (index >= this.nounElements.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.nounElements[index];
    }

    @Override
    public String get(DatabaseRequester requester) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getElementsCount() {
        return this.nounElements.length;
    }
}
