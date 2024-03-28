package mainFolder;


import baseClasses.*;
import baseClasses.humans.Man;
import baseClasses.humans.Woman;

import baseClasses.pets.Dog;
import baseClasses.pets.Fish;
import baseClasses.pets.OtherPets;


public class FamilyMainClass {
    public static void main(String[] args) {
        Fish fish = new Fish("sys", 3, 50, new String[]{});
        System.out.println("=============================================================");
        System.out.println(fish);
        fish.eat();
        fish.respond();    // class extends Pet

        System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
        OtherPets parrot = new OtherPets("Parrot", "DAD", 10, 99, 2, true, false, new String[]{"Talk", "Sing"}, true);
        System.out.println(parrot);
        parrot.respond();   // UNKNOWN by default
        System.out.println(parrot.getSpecies().name());


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Man human1M = new Man("Alex", "Bal", 1983, 180);            // adds pets To families
        Woman human1W = new Woman("Sweet", "Wallet", 1984, 190);
        Family family = new Family(human1W, human1M);
        family.setPet(new Dog("qwe ", 1, 2, new String[]{}));
        System.out.println(family.getPet());
        family.setPet(new OtherPets("Snake", "Push", 3, 60, 0, false, false, new String[]{}, true));
        System.out.println(family.getPet());



        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");


        Family family1 = new Family(human1W, human1M);
        family1.addChild(family.bornChild(family));         // create child with class Man/Women
        family1.addChild(family.bornChild(family));
        family1.addChild(family.bornChild(family));
        family1.addChild(family.bornChild(family));
        family1.addChild(family.bornChild(family));
        family1.sendChildrenToPrint();
        System.out.println(family1);


    }
}
