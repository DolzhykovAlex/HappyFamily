package baseClasses.pets;

import baseClasses.enums.Species;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {


    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;


    public Pet(String nickname, int age, int trickLevel, String[] habits) {
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(species, pet.species) && Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age);
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }


    public void eat() {
        System.out.println("Я ї'м!");
    }

    public void respond() {
        System.out.println("Привіт, хазяїн. Я -" + nickname + " . Я скучив!");
    }


    public String trickLevelCheck() {
        if (trickLevel > 50)
            return "very cunning";
        return "almost not cunning";
    }



    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    @Override
    public String toString() {
        return
                species.getEnumValueToString()
                        + "( nickname='" + nickname
                        + "', age=" + age
                        + ", trickLevel=" + trickLevel
                        + ", habits= "
                        + Arrays.toString(habits)
                        + ", has species: "
                        + this.species
                        + ")";
    }
}







