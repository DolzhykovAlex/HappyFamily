package mainFolder;


import baseClasses.families.FamilyController;
import baseClasses.humans.Man;
import baseClasses.humans.Woman;


public class FamilyMainClass {
    public static void main(String[] args) {

        Woman human1W = new Woman("Sweet", "Wallet", "19/03/1980", 190);
        Man human1M = new Man("Tim", "Box", "19/03/1989", 190);

        FamilyController fc = new FamilyController();

        System.out.println("Get all Families== \n  " + fc.getAllFamilies());                  //getAllFamilies()

        System.out.println();
        fc.getFamilyById(0).addChild(human1W);
        System.out.println("-++++++++++++++++++++++++++++++++++++++++++++-");
        System.out.println("Families < count = 3\n " + fc.getFamiliesLessThan(3));          // getFamiliesLessThan
        System.out.println("Families > count = 2\n " + fc.getFamiliesBiggerThan(2));        //getFamiliesBiggerThan
        System.out.println(fc.countFamiliesWithMemberNumber(2) + " Count families with 2 members\n ");  //countFamiliesWithMemberNumber(2)


        fc.getFamilyById(0).addChild(human1M);
        fc.deleteFamilyByIndex(2);
        fc.deleteFamilyByIndex(2);
        fc.deleteFamilyByIndex(2);
        fc.bornChild(fc.getFamilyById(1), "DIMA", "IRA");

        fc.displayAllFamilies();
        System.out.println("+=======================================================");
        fc.deleteAllChildrenOlderThen(1);                         //deleteAllChildrenOlderThen
        fc.displayAllFamilies();


    }

}