package baseClasses.humans;

import baseClasses.pets.Pet;

public final class Woman extends Human {
    public Woman(String name, String surname, long birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Woman(String name, String surname, String birthDate, int iq) {
        super(name, surname, UtilsHuman.parseDateFromStringToLong(birthDate), iq);
    }

    public Woman(String name, String surname, long birthDate, int iq, String[] schedule) {
        super(name, surname, birthDate, iq);
    }

    @Override
    public void greetPet() {
        if (family.checkPet())
            for (Pet x : this.family.getPets())
                System.out.println("Привіт, " + x.getNickname() + "Це я твоя власниця " + getName());
    }

    @Override
    public void describePet() {
        if (family.checkPet())
            for (Pet x : this.family.getPets())
                System.out.println("У мене є " + x.getSpecies() + " їй " + x.getAge() + " років, він " + x.trickLevelCheck());

    }

    public void goToBeautyCenter() {
        System.out.println("Добре відпочила ");
    }


}
