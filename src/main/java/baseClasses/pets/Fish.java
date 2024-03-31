package baseClasses.pets;

import baseClasses.enums.Species;

import java.util.HashSet;


public class Fish extends Pet {


    public Fish(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.FISH);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public void respond() {
        System.out.println("  Буль Буль Буль Буль");
    }

}
