package baseClasses.pets;

import baseClasses.enums.Species;
import baseClasses.interfasesOfProgect.CanFoul;

public class DomesticCat extends Pet implements CanFoul {


    public DomesticCat( String nickname, int age, int trickLevel, String[] habits) {
        super( nickname, age, trickLevel, habits);
        this.setSpecies(Species.DOMESTICCAT);
    }

    @Override
    public void respond() {
        System.out.println("Привіт, хазяїн. Я -" + this.getNickname() + " . Я скучив!");
    }

    @Override
    public void canFoul() {
        System.out.println("Сам винен. Треба частіше змінювати наповнювач горшика");
    }
}
