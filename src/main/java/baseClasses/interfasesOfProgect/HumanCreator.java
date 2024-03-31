package baseClasses.interfasesOfProgect;

import baseClasses.Family;
import baseClasses.humans.Human;


public interface HumanCreator {

    String[] NAMES_WOMAN = new String[]{"Sveta", "Dasha", "Valya", "Yulya"};
    String[] NAMES_MAN = new String[]{"Alex", "Dima", "Fedor", "Petr", "Mikola"};


    Human bornChild(Family family);
}