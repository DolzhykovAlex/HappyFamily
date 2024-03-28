package baseClasses.pets;

import baseClasses.enums.Species;

public class RoboCat extends Pet{


    public RoboCat( String nickname, int age, int trickLevel, String[] habits) {
        super( nickname, age, trickLevel, habits);
        this.setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond() {
        System.out.println("Бип бип  хазяїн. Я -" + this.getNickname() + " . Я скучив! Я приготував каву та вбрався");
    }
}
