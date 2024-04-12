package baseClasses.interfasesOfProgect;




import baseClasses.families.Family;

import java.util.List;

public interface Dao<T> {

    List<T>  getAllFamilies();
     Family getFamilyByIndex(int index);
     boolean  deleteFamily (T t);
     boolean  deleteFamily (int index);
     boolean  saveFamily( T y);   // true - already exist, false - new family
}
