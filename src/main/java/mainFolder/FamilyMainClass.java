package mainFolder;


import baseClasses.*;
import baseClasses.enums.DayOfWeek;
import baseClasses.humans.Man;
import baseClasses.humans.Woman;

import baseClasses.pets.Dog;
import baseClasses.pets.Fish;
import baseClasses.pets.OtherPets;
import baseClasses.pets.Pet;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FamilyMainClass {
    public static void main(String[] args) {
        Fish fish = new Fish("Nemo", 3, 50, new HashSet<>());
        System.out.println("=============================================================");
        System.out.println(fish);
        fish.eat();
        fish.respond();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Man human1M = new Man("Obama", "Bal", 1983, 180);            // adds pets To families
        Woman human1W = new Woman("Sweet", "Wallet", 1984, 190);
        Family family = new Family(human1W, human1M);
        Dog dog = new Dog("Mars ", 1, 2, new HashSet<>(Arrays.asList("Play", "Eat", "Sleep")));
        System.out.println(family.getPets().add(dog));
        System.out.println(family.getPets().add(fish));
        System.out.println(family.getPets());
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        human1M.greetPet();                                    //human methods
        human1M.describePet();
        human1M.feedPet(false);
        System.out.println("_____________________________________________________________________");
        family.addChild(family.bornChild(family));         // create child with class Man/Women
        family.addChild(family.bornChild(family));         // create child with class Man/Women
        family.addChild(family.bornChild(family));         // create child with class Man/Women
        family.addChild(family.bornChild(family));         // create child with class Man/Women
        family.addChild(family.bornChild(family));         // create child with class Man/Women
        family.addChild(human1M);
        family.sentChildrenToPrint();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        family.deleteChild(1);                               // delete children
        System.out.println(family.deleteChild(human1M));
        family.sentChildrenToPrint();
        System.out.println("===============================================");
        human1M.setSchedule();                                   // fill schedule
        System.out.println(human1M);


    }
}
