import NameGenerator.NamePartRepository;
import NameGenerator.RandomNameGenerator;

import java.sql.SQLException;
import java.util.*;

public class NameGeneratorPresenter {
    private final NamePartRepository colorRepository;
    private final NamePartRepository qualityRepository;
    private final NamePartRepository nounRepository;
    private final RandomNameGenerator generator;


    private final String startMessage = "Random Name Generator ver. 0.1";
    private final String startMenu = """
            Please, choose one of the options:
            
            1 - Generate random name
            2 - View tables
            3 - Add custom value
            4 - Replace existing value
            5 - Delete value
            0 - Exit
            """;
    private final String tableSelectionMenu = """
            Please, choose one of the options:
            
            1 - Colors table
            2 - Qualities table
            3 - Nouns table
            """;
   private final  String wrongMenuInputMessage = "Please, choose one of the options.";


    NameGeneratorPresenter(NamePartRepository colorRepository,
                           NamePartRepository qualityRepository,
                           NamePartRepository nounRepository) throws SQLException {
        generator = new RandomNameGenerator(colorRepository,
                                            qualityRepository,
                                            nounRepository);
        this.colorRepository = colorRepository;
        this.qualityRepository = qualityRepository;
        this.nounRepository = nounRepository;
    }

    public void enterStartMenu() throws SQLException {
        System.out.println(startMessage);
        Scanner scanner = new Scanner(System.in);
        System.out.println(startMenu);

        int input = scanner.nextInt();
        boolean exit = false;
        while (!exit) {
            try {
                switch (input) {
                    case 1:
                        enterGeneratorMenu();
                        System.out.println(startMenu);
                        input = scanner.nextInt();
                        break;

                    case 2:
                        enterShowAllValuesMenu();
                        System.out.println(startMenu);
                        input = scanner.nextInt();
                        break;

                    case 3:
                        enterAddNewValuesMenu();
                        System.out.println(startMenu);
                        input = scanner.nextInt();
                        break;
                    case 4:
                        enterReplaceValueMenu();
                        System.out.println(startMenu);
                        input = scanner.nextInt();
                        break;
                    case 5:
                        enterDeleteValueMenu();
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
            } catch (InputMismatchException e) {
                System.out.println(wrongMenuInputMessage);
                System.out.println(startMenu);
                input = scanner.nextInt();
            }
        }

    }

    private NamePartRepository enterTableSelectionMenu() {
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

    private void enterGeneratorMenu() throws SQLException {
        System.out.println(generator.generateName());
    }

    private void enterShowAllValuesMenu() {
        NamePartRepository repository = enterTableSelectionMenu();
        System.out.println(Arrays.toString(repository.getAllValues()));
    }

    private void enterAddNewValuesMenu() {
        NamePartRepository repository = enterTableSelectionMenu();

        System.out.println("Enter value and press Enter. Press 0 to exit.");
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("0")) {
            repository.addValue(inputLine);
            inputLine = scanner.nextLine();
        }
    }

    private void enterReplaceValueMenu() {
        NamePartRepository repository = enterTableSelectionMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value you want to replace and press Enter.");
        String oldValue = scanner.nextLine();
        System.out.println("Enter new value and press Enter.");
        String newValue = scanner.nextLine();
        repository.updateValue(oldValue, newValue);
    }

    private void enterDeleteValueMenu() {
        NamePartRepository repository = enterTableSelectionMenu();
        System.out.println("Enter value you want to delete and press Enter.");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        repository.deleteValue(value);

    }


}
