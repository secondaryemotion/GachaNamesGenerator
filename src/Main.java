public class Main {
    public void main (String[] arg) {
        NameRepository database = new NameRepository();
        RandomNameGenerator generator = new RandomNameGenerator(database);
        System.out.println(generator.generateName());
    }
}
