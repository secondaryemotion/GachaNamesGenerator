import java.sql.SQLException;
import java.util.*;

public class NameGeneratorPresenter {
    private final NamePartRepository colorRepository;
    private final NamePartRepository qualityRepository;
    private final NamePartRepository nounRepository;
    private final RandomNameGenerator generator;


    String startMessage = "Random Name Generator ver. 0.1";
    String startMenu = """
            Please, choose one of the options:
            
            1 - Generate random name
            2 - View tables
            3 - Add custom value
            4 - Replace existing value
            5 - Delete value
            0 - Exit
            """;
    String tableSelectionMenu = """
            Please, choose one of the options:
            
            1 - Colors table
            2 - Qualities table
            3 - Nouns table
            """;
    String wrongMenuInputMessage = "Please, choose one of the options.";


    NameGeneratorPresenter(NamePartRepository colorRepository,
                           NamePartRepository qualityRepository,
                           NamePartRepository nounRepository) throws SQLException {
        generator = new RandomNameGenerator(colorRepository,
                                            qualityRepository,
                                            nounRepository);
        this.colorRepository = colorRepository;
        this.qualityRepository = qualityRepository;
        this.nounRepository = nounRepository;
        System.out.println(startMessage);
        enterStartMenu();
    }

    public void enterStartMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(startMenu);
        NamePartRepository repository;
        int input = scanner.nextInt();
        boolean exit = false;
        while (!exit) {
            switch (input) {
                case 1:
                    System.out.println(generator.generateName());
                    System.out.println(startMenu);
                    input = scanner.nextInt();
                    break;

                case 2:
                    repository = enterTableSelectionMenu();
                    System.out.println(Arrays.toString(repository.getAllValues()));
                    System.out.println(startMenu);
                    input = scanner.nextInt();
                    break;

                case 3:
                    repository = enterTableSelectionMenu();
                    System.out.println("Enter value and press Enter. Press 0 to exit.");
                    String inputLine = scanner.nextLine();
                    while (!inputLine.equals("0")) {
                        inputLine = scanner.nextLine();
                        repository.addValueToTable(inputLine);
                    }
                    System.out.println(startMenu);
                    input = scanner.nextInt();
                    break;
                case 4:
                    repository = enterTableSelectionMenu();
                    System.out.println("Enter value you want to replace and press Enter.");
                    String oldValue = scanner.nextLine();
                    System.out.println("Enter new value and press Enter.");
                    String newValue = scanner.nextLine();
                    repository.updateValue(oldValue, newValue);
                    System.out.println(startMenu);
                    input = scanner.nextInt();
                    break;
                case 5:
                    repository = enterTableSelectionMenu();
                    System.out.println("Enter value you want to replace and press Enter.");
                    String value = scanner.nextLine();
                    repository.deleteValue(value);
                    System.out.println(startMenu);
                    input = scanner.nextInt();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println(wrongMenuInputMessage);
                    System.out.println(startMenu);
                    input = scanner.nextInt();
                    break;
            }
        }

    }

    public NamePartRepository enterTableSelectionMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(tableSelectionMenu);

        while (true) {
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    return colorRepository;
                case 2:
                    return qualityRepository;
                case 3:
                    return nounRepository;
                default:
                    System.out.println(wrongMenuInputMessage);
                    scanner.next();
            }
        }

    }
}
