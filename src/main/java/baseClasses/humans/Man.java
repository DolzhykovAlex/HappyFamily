package baseClasses.humans;

public final class Man extends Human{
    public Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }
    public Man(String name, String surname, int year, int iq, String[] schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (null ==  getFamily().getPet()) System.out.println("I don`n have pet ((( ");
        else System.out.println("Привіт, нарешті я вдома " + getFamily().getPet().getNickname());
    }

    @Override
    public void describePet() {
        if (null == getFamily().getPet()) System.out.println("I don`n have pet ((( ");
        else
            System.out.println("У мене є " + getFamily().getPet().getSpecies() + " їй " +  getFamily().getPet().getAge() + " років, він " + getFamily().getPet().trickLevelCheck());

    }

    public void goFishing(){
        System.out.println("Чомусь цей метод нічого не повертає (((((((( ");
    }


}
