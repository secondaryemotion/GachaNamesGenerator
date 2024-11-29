public class RandomNameGenerator {
    public String generateName(){
        NameDatabase database = new NameDatabase();
        String name = "%s %s %s";
        return String.format(name,database.getFirstNamePart(),database.getSecondNamePart(),
                database.getThirdNamePart());
    }

}
