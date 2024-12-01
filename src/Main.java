import DatabaseManager.DatabaseRequester;

import java.sql.SQLException;

public class Main {
    public void main (String[] args) throws SQLException {

        DatabaseRequester requester = new DatabaseRequester();
        NamePartRepository colorRepository = new ColorRepository(requester);
        NamePartRepository qualityRepository = new QualityRepository(requester);
        NamePartRepository nounRepository = new NounRepository(requester);

        RandomNameGenerator generator = new RandomNameGenerator(colorRepository,
                                                                qualityRepository,
                                                                nounRepository);
        System.out.println(generator.generateName());
    }
}
