package mainFolder;


import baseClasses.families.CollectionFamilyDao;
import baseClasses.families.Family;
import baseClasses.families.FamilyService;
import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.UtilsHuman;
import baseClasses.humans.Woman;
import baseClasses.pets.Dog;
import baseClasses.pets.DomesticCat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FamilyMainClass {
    public static void main(String[] args) {

        Woman human1W = new Woman("Sweet", "Wallet", "19/03/1980", 190); // constructor with string birthDate
        Man human1M = new Man("Tim", "Box", "19/03/1989", 190);
        System.out.println(human1W);
//        long l = UtilsHuman.parseDateFromStringToLong("05/04/2020");                          // String->long
//        System.out.println( "\n birthdate=  " + UtilsHuman.parseDateFromLongToString(l));
//        System.out.println("\n Unix time=  " +l + "\n" );
//        Man man1M= new Man("Max","Min",1586034000,180);                   // constructor with long birthDate
//        System.out.println(man1M);
//        System.out.println(UtilsHuman.parseDateFromLongToString(l));
//        UtilsHuman.describeAge(man1M.getBirthDate());                                          // age from 05/04/2020

        System.out.println();
        FamilyService fs = new FamilyService();
        fs.getFamilyDao().getAllFamilies().size();
        System.out.println(fs.getAllFamilies());
        fs.displayAllFamilies();
        fs.getAllFamilies().get(0).addChild(human1W);
        System.out.println("-++++++++++++++++++++++++++++++++++++++++++++-");
        fs.getFamiliesBiggerThan(2);
        System.out.println(fs.countFamiliesWithMemberNumber(2));
        Family family = fs.createNewFamily(human1W, human1M);
        fs.displayAllFamilies();
        System.out.println(family);
        fs.deleteFamilyByIndex(2);
        fs.deleteFamilyByIndex(2);
        fs.deleteFamilyByIndex(2);
        fs.deleteFamilyByIndex(2);
        System.out.println("++++++++++++++++++++++++++++++++$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        fs.displayAllFamilies();
        Family familyUpdated = fs.bornChild(fs.getAllFamilies().get(1), "Boy", "Girl");
    //    System.out.println(familyUpdated);
        System.out.println(fs.getAllFamilies().get(1).getChildren().get(0).getClass());
        Family familyUpdated2 = fs.adoptChild(fs.getAllFamilies().get(0), new Man("Ronaldo", "Greek", "05/11/2021", 140));
     //   System.out.println(familyUpdated2);
        fs.displayAllFamilies();
        System.out.println("****************************************************************");
        fs.getAllFamilies().get(0).addChild(human1M );
        fs.displayAllFamilies();
        System.out.println("+=======================================================");
        fs.deleteAllChildrenOlderThen(1);
        fs.displayAllFamilies();
        System.out.println("Count families= "+ fs.count());
        System.out.println(fs.getFamilyById(0));
        System.out.println("#################################################");
        System.out.println(fs.getPets(0));
        fs.getAllFamilies().get(0).getPets().add(new DomesticCat("Luna ", 2, 20, new HashSet<>(Arrays.asList("Play", "Eat", "Sleep"))));
        System.out.println(fs.getPets(0));
        fs.addPet(1,new DomesticCat("Mars ", 1, 20, new HashSet<>(Arrays.asList("Play", "Eat", "Sleep"))));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        fs.displayAllFamilies();
    }


}