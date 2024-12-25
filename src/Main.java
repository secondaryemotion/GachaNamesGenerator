import NameGenerator.DatabaseManager.DatabaseConnectionSpec;
import NameGenerator.DatabaseManager.DatabaseRequester;
import NameGenerator.ColorRepository;
import NameGenerator.NamePartRepository;
import NameGenerator.NounRepository;
import NameGenerator.QualityRepository;

import java.sql.SQLException;

public class Main {
    public static void main (String[] args) throws SQLException {

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/mysql";
        DatabaseConnectionSpec databaseConnectionSpec = new DatabaseConnectionSpec(user,password,url);
        DatabaseRequester requester = new DatabaseRequester(databaseConnectionSpec);
        NamePartRepository colorRepository = new ColorRepository(requester);
        NamePartRepository qualityRepository = new QualityRepository(requester);
        NamePartRepository nounRepository = new NounRepository(requester);
        NameGeneratorPresenter presenter = new NameGeneratorPresenter(colorRepository,qualityRepository,nounRepository);
        presenter.enterStartMenu();
    }
}
