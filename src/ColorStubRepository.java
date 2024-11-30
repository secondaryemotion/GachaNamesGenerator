import DatabaseManager.*;


public class ColorStubRepository implements NamePartRepository{
    private String[] colorElements = {"Red", "Blue","Violet"};


    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException{
        if (index >= this.colorElements.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.colorElements[index];
    }

    @Override
    public String get(DatabaseRequester requester) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getElementsCount() {
        return this.colorElements.length;
    }
}
