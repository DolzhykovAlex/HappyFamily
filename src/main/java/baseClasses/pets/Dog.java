package baseClasses.pets;

import baseClasses.enums.Species;
import baseClasses.interfasesOfProgect.CanFoul;

import java.util.HashSet;

public class Dog extends Pet implements CanFoul {


    public Dog(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.DOG);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public void respond() {
        System.out.println("Привіт, хазяїн. Твій собака" + this.getNickname() + " . Я скучив! Я хочу Гуляти !!!!!");
    }

    @Override
    public void canFoul() {
        System.out.println("Пробачте я не дочекався прогулянки((((((((((");
    }
}
