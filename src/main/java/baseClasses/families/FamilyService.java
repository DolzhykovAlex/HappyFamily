package baseClasses.families;

import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.UtilsHuman;
import baseClasses.interfasesOfProgect.Dao;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import baseClasses.pets.Pet;


public class FamilyService {

    private final Dao<Family> familyDao;


    public FamilyService() {
        this.familyDao = new CollectionFamilyDao();
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        int i = 0;
        for (Family f : familyDao.getAllFamilies()) {
            System.out.println("Family index= " + i + " {" + f + "}\n");
            i++;
        }
    }

    public Dao<Family> getFamilyDao() {
        return familyDao;
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        List<Family> ls = new ArrayList<>();
        for (Family f : familyDao.getAllFamilies()) {
            if (f.countFamily() > count) {
                System.out.println("Family Bigger then= " + count + " peoples {" + f + "}\n");
                ls.add(f);
            }
        }
        return ls;
    }

    public List<Family> getFamiliesLessThan(int count) {
        List<Family> ls = new ArrayList<>();
        for (Family f : familyDao.getAllFamilies()) {
            if (f.countFamily() < count) {
                System.out.println("Family Less then= " + count + " peoples  {" + f + "}\n");
                ls.add(f);
            }
        }
        return ls;
    }

    public int countFamiliesWithMemberNumber(int count) {
        int i = 0;
        for (Family f : familyDao.getAllFamilies())
            if (f.countFamily() == count) i++;
        return i;
    }

    public Family createNewFamily(Human mother, Human father) {
        Family family = new Family(mother, father);
        System.out.println("This family was exist in the base= " + familyDao.saveFamily(family));
        return family;
    }

    public void deleteFamilyByIndex(int index) {
        System.out.println("Family with index= " + index + " was deleted- " + familyDao.deleteFamily(index));
    }

    public Family bornChild(Family family, String manName, String womenName) {
        Human child = family.bornChild(family);
        if (child.getClass() == Man.class) child.setName(manName);
        else child.setName(womenName);
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human human) {
        family.addChild(human);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        for (Family f : familyDao.getAllFamilies()) {
            for (int j = 0; j < f.getChildren().size(); j++) {
                String dateInString = UtilsHuman.parseDateFromLongToString(f.getChildren().get(j).getBirthDate());
                LocalDate date = LocalDate.parse(dateInString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Period period = Period.between(date, LocalDate.now());
                if (period.getYears() > age) {
                    f.deleteChild(j);
                    j--;
                }
            }
        }
    }

    public int count(){
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index){
        return familyDao.getFamilyByIndex(index);
    }

    public Set<Pet> getPets(int index){
        if (familyDao.getAllFamilies().get(index).getPets().isEmpty())
                return Collections.emptySet();
        return familyDao.getAllFamilies().get(index).getPets();

    }

    public void addPet(int index, Pet pet){
        familyDao.getAllFamilies().get(index).getPets().add(pet);
    }


}