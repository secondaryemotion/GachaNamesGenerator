package NameGenerator;

import java.sql.SQLException;

public class RandomNameGenerator {

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



    public String generateName() throws SQLException {
        String color = colorRepository.getRandom();
        String quality = qualityRepository.getRandom();
        String noun = nounRepository.getRandom();

        return String.format(nameFormatString,color,quality,noun);
    }


}
