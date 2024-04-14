package baseClasses.families;

import baseClasses.interfasesOfProgect.Dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements Dao<Family> {

    List<Family> dataBase = new ArrayList<>();
    private final File file = new File("src/main/java/baseClasses/files/DataBase.bin");


    @Override
    public List<Family> getAllFamilies() {
        return dataBase;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if ((index >= 0) && (dataBase.size() > index)) return dataBase.get(index);
        return null;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return dataBase.remove(family);
    }

    @Override
    public boolean deleteFamily(int index) {
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
        System.out.println( "Load from file ++++++++++++++++++++++++++++++++++++++++");
        try (FileInputStream fin = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fin);
            Object object = ois.readObject();
            dataBase = (ArrayList<Family>) object;
            ois.close();
            if (!dataBase.isEmpty())
                System.out.println("Add DataBase From file Successful");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Class not found or was recently changed");

        } catch (ClassCastException ex) {
            System.out.println("Cant cast to ArrayList<Workers> so Create new one");
        }
    }


    @Override
    public void loadData(List<Family> object) throws IOException {
        try {

            final FileOutputStream fos = new FileOutputStream(file);
            final ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Save to File src/main/java/baseClasses/files/DataBase.bin");
            oos.writeObject(object);
            oos.close();
        } catch (
                FileNotFoundException ex) {
            System.out.println("File database.bin not found ");
        }
    }
}