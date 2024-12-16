package NameGenerator;

public class NameRepository {

    String[] firstNames = {"Super","Mega","Legendary"};
    String[] secondNames = {"Red", "Blue","Violet"};
    String[] thirdNames = {"Plasma TV","Terrifier 3000"};


    public String getFirstNamePart(){
         int firstNameIndex = (int) (Math.random()* firstNames.length);
         return firstNames[firstNameIndex];
    }

    public String getSecondNamePart(){
         int secondNameIndex = (int) (Math.random()* secondNames.length);
         return secondNames[secondNameIndex];
    }

    public String getThirdNamePart(){
         int thirdNameIndex = (int) (Math.random()* thirdNames.length);
         return thirdNames[thirdNameIndex];
    }


}
