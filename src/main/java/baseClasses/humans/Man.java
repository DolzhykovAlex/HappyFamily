package baseClasses.humans;

import baseClasses.pets.Pet;



public final class Man extends Human {
    public Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    public Man(String name, String surname, int year, int iq, String[] schedule) {
        super(name, surname, year, iq);
    }

    @Override
    public void greetPet() {
        if (family.checkPet())
            for (Pet x : this.family.getPets())
                System.out.println("Привіт, нарешті я вдома " + x.getNickname());

    }

    @Override
    public void describePet() {
        if (family.checkPet())
            for (Pet x : this.family.getPets())
                System.out.println("У мене є " + x.getSpecies().getEnumValueToString().toLowerCase() + " їй " + x.getAge() + " років, він " + x.trickLevelCheck());
    }

    public void goFishing() {
        System.out.println("Чомусь цей метод нічого не повертає (((((((( ");
    }


}
