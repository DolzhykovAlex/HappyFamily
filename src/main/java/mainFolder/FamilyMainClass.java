package mainFolder;


import baseClasses.enums.DayOfWeek;
import baseClasses.families.Family;
import baseClasses.families.FamilyController;
import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.UtilsHuman;
import baseClasses.humans.Woman;
import baseClasses.menu.MenuClass;
import baseClasses.pets.Dog;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class FamilyMainClass {
    public static void main(String[] args) throws IOException {
        MenuClass.mainManu();
//        File file = new File("src/main/java/baseClasses/files/DataBase.bin");
//        String absPath = file.getAbsolutePath();
//        System.out.println(absPath);
//        System.out.println(file.exists());
//        FileWriter fv = new FileWriter(file);
//
//        fv.close();

    }


//    public static void createFile(ArrayList<Family> object) throws IOException {
//        try {
//            final ArrayList<Family> qqq = object;
//            final FileOutputStream fos = new FileOutputStream("src/main/java/baseClasses/files/DataBase.bin");
//            final ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(qqq);
//            oos.close();
//        } catch (
//                FileNotFoundException ex) {
//            System.out.println("File database.bin not found ");
//        }
//    }

//    public static ArrayList<Family> readFile() {
//        ArrayList<Family> arrayDataBase = new ArrayList<>();
//        try (FileInputStream fin = new FileInputStream("src/main/java/baseClasses/files/DataBase.bin")) {
//            ObjectInputStream ois = new ObjectInputStream(fin);
//            Object object = ois.readObject();
//            arrayDataBase = (ArrayList<Family>) object;
//            if (!arrayDataBase.isEmpty())
//                System.out.println("Add DataBase From file Successful");
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not found");
//            return new ArrayList<>();
//        } catch (IOException | ClassNotFoundException ex) {
//            System.out.println("Class not found or was recently changed");
//            return new ArrayList<>();
//
//        } catch (ClassCastException ex) {
//            System.out.println("Cant cast to ArrayList<Workers> so Create new one");
//            return new ArrayList<>();
//
//        }
//        return arrayDataBase;
//    }
}