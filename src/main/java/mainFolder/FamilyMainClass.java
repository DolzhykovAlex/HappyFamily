package mainFolder;



import baseClasses.humans.Man;
import baseClasses.humans.UtilsHuman;
import baseClasses.humans.Woman;




public class FamilyMainClass {
    public static void main(String[] args)  {

        Woman human1W = new Woman("Sweet", "Wallet", "19/03/1980", 190); // constructor with string birthDate
        System.out.println(human1W);
        long l = UtilsHuman.parseDateFromStringToLong("05/04/2020");                          // String->long
        System.out.println( "\n birthdate=  " + UtilsHuman.parseDateFromLongToString(l));
        System.out.println("\n Unix time=  " +l + "\n" );
        Man man1M= new Man("Max","Min",1586034000,180);                   // constructor with long birthDate
        System.out.println(man1M);
        System.out.println(UtilsHuman.parseDateFromLongToString(l));
        UtilsHuman.describeAge(man1M.getBirthDate());                                          // age from 05/04/2020






    }


}