import DatabaseManager.DatabaseRequester;

import java.sql.SQLException;

public class RandomNameGenerator {

    private DatabaseRequester requester;
    private NamePartRepository colorRepository;
    private NamePartRepository qualityRepository;
    private NamePartRepository nounRepository;
    private final String nameFormatString = "%s %s %s";

    public RandomNameGenerator(NamePartRepository colorRepository,
                               NamePartRepository qualityRepository,
                               NamePartRepository nounRepository){
        this.colorRepository = colorRepository;
        this.qualityRepository = qualityRepository;
        this.nounRepository = nounRepository;
    }


    public String generateName() {
        String color = generateNamePart(colorRepository);
        String quality = generateNamePart(qualityRepository);
        String noun = generateNamePart(nounRepository);

        return String.format(nameFormatString,color,quality,noun);
    }

    public String generateName(DatabaseRequester requester) throws SQLException {
        String color = colorRepository.get(requester);
        String quality = qualityRepository.get(requester);
        String noun = nounRepository.get(requester);

        return String.format(nameFormatString,color,quality,noun);
    }

    public String generateNamePart(NamePartRepository nameRepository){
        int elementsCount = nameRepository.getElementsCount();
        int randomIndex = (int) (Math.random()* elementsCount);

        return nameRepository.get(randomIndex);
    }

}
