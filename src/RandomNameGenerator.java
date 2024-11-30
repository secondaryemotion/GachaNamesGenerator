public class RandomNameGenerator {

    private NamePartRepository colorDatabase;
    private NamePartRepository qualityDatabase;
    private NamePartRepository nounDatabase;
    private final String nameFormatString = "%s %s %s";

    public RandomNameGenerator(NamePartRepository colorDatabase,
                               NamePartRepository qualityDatabase,
                               NamePartRepository nounDatabase){
        this.colorDatabase = colorDatabase;
        this.qualityDatabase = qualityDatabase;
        this.nounDatabase = nounDatabase;
    }

    public String generateName(){
        String color = generateNamePart(colorDatabase);
        String quality = generateNamePart(qualityDatabase);
        String noun = generateNamePart(nounDatabase);

        return String.format(nameFormatString,color,quality,noun);
    }

    public String generateNamePart(NamePartRepository nameRepository){
        int elementsCount = nameRepository.getElementsCount();
        int randomIndex = (int) (Math.random()* elementsCount);

        return nameRepository.get(randomIndex);
    }

}
