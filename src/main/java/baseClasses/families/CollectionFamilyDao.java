package baseClasses.families;

import baseClasses.interfasesOfProgect.Dao;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements Dao<Family> {

    List<Family> dataBase = new ArrayList<>();



    public CollectionFamilyDao() { }

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
}

