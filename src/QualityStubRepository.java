public class QualityStubRepository implements NamePartRepository{
    private String[] qualityElements = {};

    @Override
    public String get(int index) throws Exception{
        if (index >= this.qualityElements.length){
            throw new Exception("Index out of bounds"); // поискать эксепшен argumentOutOfRange
        }
        return "";
    }

    @Override
    public int getElementsCount() {
        return 0;
    }
}
