package mainFolder;


import baseClasses.families.CollectionFamilyDao;
import baseClasses.families.Family;
import baseClasses.families.FamilyController;
import baseClasses.families.FamilyService;
import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.UtilsHuman;
import baseClasses.humans.Woman;
import baseClasses.pets.Dog;
import baseClasses.pets.DomesticCat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FamilyMainClass {
    public static void main(String[] args) {

        Woman human1W = new Woman("Sweet", "Wallet", "19/03/1980", 190);
        Man human1M = new Man("Tim", "Box", "19/03/1989", 190);

        FamilyController fc = new FamilyController();

        System.out.println(fc.getAllFamilies());                  //getAllFamilies()
        fc.displayAllFamilies();                                  //displayAllFamilies();
        System.out.println();
        fc.getAllFamilies().get(0).addChild(human1W);
        System.out.println("-++++++++++++++++++++++++++++++++++++++++++++-");

        System.out.println( fc.getFamiliesLessThan(3));          // getFamiliesLessThan
        System.out.println( fc.getFamiliesBiggerThan(2));        //getFamiliesBiggerThan
        System.out.println(fc.countFamiliesWithMemberNumber(2)+  "Count families ");  //countFamiliesWithMemberNumber(2)
     //   Family family = fc.createNewFamily(human1W, human1M);           // createNewFamily
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        fc.displayAllFamilies();
      //  System.out.println(family);
        fc.deleteFamilyByIndex(2);
        fc.deleteFamilyByIndex(2);                                      // deleteFamilyByIndex
        fc.deleteFamilyByIndex(2);
        fc.deleteFamilyByIndex(2);
        System.out.println("++++++++++++++++++++++++++++++++$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        fc.displayAllFamilies();
        Family familyUpdated = fc.bornChild(fc.getAllFamilies().get(1), "Boy", "Girl");   //bornChild
        System.out.println("Family + born child= " +familyUpdated);
        System.out.println("Child class= "+fc.getAllFamilies().get(1).getChildren().get(0).getClass());
        Family familyUpdated2 = fc.adoptChild(fc.getAllFamilies().get(0), new Man("Ronaldo", "Greek", "05/11/2021", 140));   //adoptChild
        System.out.println(familyUpdated2);
        fc.displayAllFamilies();
        System.out.println("****************************************************************");
        fc.getAllFamilies().get(0).addChild(human1M);
        fc.displayAllFamilies();
        System.out.println("+=======================================================");
        fc.deleteAllChildrenOlderThen(1);                         //deleteAllChildrenOlderThen
        fc.displayAllFamilies();
        System.out.println("Count families in base= " + fc.count());           // count members of family
        System.out.println(" Famyly by index-- " + fc.getFamilyById(1));                 // getFamilyById
        System.out.println("#################################################");
        fc.addPet(1, new DomesticCat("Mars ", 1, 20, new HashSet<>(Arrays.asList("Play", "Eat", "Sleep")))); // add pet
        fc.displayAllFamilies();

        System.out.println("#$@#$@#$@#$@#$#@$@#$@#$@#$@#$@#$@#$@#$@#$");
        Woman human3W = new Woman("t", "Wallet", "19/03/1980", 190);
        Man human3M = new Man("Tim", "Box", "19/03/1989", 190);
        Family family2= new Family(human3W,human3M);
        fc.displayAllFamilies();
        System.out.println(fc.createNewFamily(human3W,human3M));
        fc.displayAllFamilies();



    }


}