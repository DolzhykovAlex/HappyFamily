package baseClasses.families;

import Utils.CustomLogger;
import baseClasses.interfasesOfProgect.Dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements Dao<Family> {

    List<Family> dataBase = new ArrayList<>();
    private final File file = new File("src/main/java/baseClasses/files/DataBase.bin");


    @Override
    public List<Family> getAllFamilies() {
        CustomLogger.info("getAllFamilies");
        return dataBase;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        CustomLogger.info(" try getFamilyByIndex" + index);
        if ((index >= 0) && (dataBase.size() > index)) return dataBase.get(index);
        return null;
    }

    @Override
    public boolean deleteFamily(Family family) {
        CustomLogger.info("try deleteFamily by Object Family");
        return dataBase.remove(family);
    }

    @Override
    public boolean deleteFamily(int index) {
        CustomLogger.info(" try deleteFamily by index" + index);
        int n = dataBase.size();
        if ((n > index) && (n != 0) && (index >= 0)) {
            dataBase.remove(index);
            return true;
        }
        System.out.println("This index not exist".toUpperCase());
        return false;
    }

    @Override
    public boolean saveFamily(Family y) {
        CustomLogger.info("saveFamily " + y.getFather().getSurname());
        for (int i = 0; i < dataBase.size(); i++) {
            if (dataBase.get(i).equals(y)) {
                dataBase.set(i, y);
                return true;
            }
        }
        dataBase.add(y);
        return false;
    }

    @Override
    public void uploadData() {
        CustomLogger.info("Load from file");
        System.out.println("Load from file ++++++++++++++++++++++++++++++++++++++++");
        try (FileInputStream fin = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fin);
            Object object = ois.readObject();
            dataBase = (ArrayList<Family>) object;
            ois.close();
            if (!dataBase.isEmpty())
                System.out.println("Add DataBase From file Successful");
        } catch (FileNotFoundException ex) {
            CustomLogger.error("Load from file fail FileNotFoundException");
            System.out.println("File not found");

        } catch (IOException | ClassNotFoundException ex) {
            CustomLogger.error("Load from file fail ClassNotFoundException");
            System.out.println("Class not found or was recently changed");

        } catch (ClassCastException ex) {
            CustomLogger.error("Cant cast File to List<Family>");
            System.out.println("Cant cast to List<Family> so Create new one");
        }
    }


    @Override
    public void loadData(List<Family> object) throws IOException {
        CustomLogger.info("Save to File src/main/java/baseClasses/files/DataBase.bin");
        try {
            final FileOutputStream fos = new FileOutputStream(file);
            final ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Save to File src/main/java/baseClasses/files/DataBase.bin");
            oos.writeObject(object);
            oos.close();
        } catch (
                FileNotFoundException ex) {
            CustomLogger.error("File database.bin not found FileNotFoundException");
            System.out.println("File database.bin not found ");
        }
    }
}