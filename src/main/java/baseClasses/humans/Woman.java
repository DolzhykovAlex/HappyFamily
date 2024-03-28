package baseClasses.humans;

public final class Woman extends Human{
    public Woman(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }
    public Woman(String name, String surname, int year, int iq, String[] schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (null ==  getFamily().getPet()) System.out.println("I don`n have pet ((( ");
        else System.out.println("Привіт, " + getFamily().getPet().getNickname()+  "Це я твоя власниця "+ getName());
    }

    @Override
    public void describePet() {
        if (null == getFamily().getPet()) System.out.println("I don`n have pet ((( ");
        else
            System.out.println("У мене є " + getFamily().getPet().getSpecies() + " їй " +  getFamily().getPet().getAge() + " років, він " + getFamily().getPet().trickLevelCheck());

    }

    public void goToBeautyCenter(){
        System.out.println("Добре відпочила ");
    }


}
