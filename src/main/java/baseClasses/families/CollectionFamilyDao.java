package baseClasses.families;

import baseClasses.humans.Man;
import baseClasses.humans.Woman;
import baseClasses.interfasesOfProgect.Dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionFamilyDao implements Dao<Family> {

    List<Family> dataBase = new ArrayList<>();



    public CollectionFamilyDao() {
        Man human1M = new Man("Obama", "Bal", "12/12/1983", 180);
        Woman human1W = new Woman("Sweet", "Bal", "11/11/1983", 190);
        Family family1 = new Family(human1W, human1M);
        Man human2M = new Man("Jorge", "Bush", "10/10/1983", 140);
        Woman human2W = new Woman("Hilary", "Bush", "9/5/1986", 170);
        Family family2 = new Family(human2W, human2M);
        Man human3M = new Man("Mike", "Tyson", "7/2/1990", 160);
        Woman human3W = new Woman("Agata", "Tyson", "4/3/1988", 175);
        Family family3 = new Family(human3W, human3M);
        Man human4M = new Man("Alex", "Black", "12/12/1991", 160);
        Woman human4W = new Woman("Agata", "Black", "12/12/1983", 174);
        Family family4 = new Family(human4W, human4M);
        dataBase.add(family1);
        dataBase.add(family2);
        dataBase.add(family3);
        dataBase.add(family4);
    }

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

