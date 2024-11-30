import DatabaseManager.DatabaseRequester;

import java.sql.SQLException;

public class Main {
    public void main (String[] arg) throws SQLException {
        NamePartRepository colorRepository = new ColorRepository();
        NamePartRepository qualityRepository = new QualityRepository();
        NamePartRepository nounRepository = new NounRepository();
        DatabaseRequester requester = new DatabaseRequester();
        RandomNameGenerator generator = new RandomNameGenerator(colorRepository,
                                                                qualityRepository,
                                                                nounRepository);
        System.out.println(generator.generateName(requester));
    }
}
