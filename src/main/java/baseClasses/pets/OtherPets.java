package baseClasses.pets;

import baseClasses.interfasesOfProgect.CanFoul;

import java.util.Arrays;

public class OtherPets extends Pet implements CanFoul {

    private final String speciesLocal;
    private final int legs;
    private final boolean canFly;
    private final boolean hasFur;
    private final boolean canFoulCheck;


    public String getSpeciesLocal() {
        return speciesLocal;
    }


    public OtherPets(String speciesLocal, String nickname, int age, int trickLevel, int legs, boolean canFly, boolean hasFur, String[] habits, boolean canFoulCheck) {
        super(nickname, age, trickLevel, habits);
        this.speciesLocal = speciesLocal;
        this.legs = legs;
        this.canFly = canFly;
        this.hasFur = hasFur;
        this.canFoulCheck = canFoulCheck;
    }

    @Override
    public String toString() {
        return
                speciesLocal
                        + "(nickname= '" + this.getNickname()
                        + "', age= " + this.getAge()
                        + ", trickLevel= " + this.getTrickLevel()
                        + ", habits= "
                        + Arrays.toString(this.getHabits())
                        + ", has species: canFly= " + canFly
                        + ", hasFur= " + hasFur
                        + ", numberOfLegs= " + legs
                        + ")";
    }

    @Override
    public void respond() {
        System.out.println("Привіт, хазяїн. Я Твій "+ speciesLocal +" '" + this.getNickname() + "'. Я скучив!!!!!!");
    }

    @Override
    public void canFoul() {
        System.out.println("Насправді інформація що я вмію какакти-" + canFoulCheck );
    }
}
