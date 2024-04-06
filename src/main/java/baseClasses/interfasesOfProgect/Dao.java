package baseClasses.interfasesOfProgect;




import baseClasses.families.Family;

import java.util.List;

public interface Dao<T> {

    public List<T>  getAllFamilies();
    public Family getFamilyByIndex(int index);
    public boolean  deleteFamily (T t);
    public boolean  deleteFamily (int index);
    public boolean  saveFamily( T y);   // true - already exist, false - new family
}
