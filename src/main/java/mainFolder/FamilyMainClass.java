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
        fish.setAge(4);
        fish.eat();
        fish.respond();

        System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
        OtherPets parrot = new OtherPets("Parrot", "DAD", 10, 99, 2, true, false, new String[]{"Talk", "Sing"}, true);
        System.out.println(parrot);
        parrot.respond();
        System.out.println(parrot.getSpecies().name());
        Man human1M = new Man("Alex", "Bal", 1983, 180);
        Woman human1W = new Woman("Sweet", "Wallet", 1984, 190);
        Man human2M = new Man("Max", "Min", 1999, 150);
        Woman human2W = new Woman("Fusion", "Max", 1997, 160, new String[]{"day 1 Task1", "day2 Task2", "day 3 Task3", "day4 Task4", "day 5 Task5,"});
        Family family1 = new Family(human1W, human1M);
        System.out.println(human1M.getFamily());
        family1.addChild(human1M);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Family family = new Family(human1W, human1M);
        family.addChild(human2M);
        family.addChild(human2W);
        System.out.println(family.deleteChild(5));
        System.out.println(family);
        System.out.println(family.deleteChild(human2W));
        System.out.println(family);
        family.setPet(new Dog("qwe ", 1, 2, new String[]{}));
        family.setPet(new OtherPets("Snake", "Push", 3, 60, 0, false, false, new String[]{}, true));
        System.out.println(family);


    }
}
