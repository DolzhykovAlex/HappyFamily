package baseClasses.families;

import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.UtilsHuman;
import baseClasses.interfasesOfProgect.Dao;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        IntStream.range(0, familyDao.getAllFamilies().size())
                .forEach(ind -> System.out.println("Family index= " + ind + " {" + familyDao.getFamilyByIndex(ind) + "}\n"));
    }

    public Dao<Family> getFamilyDao() {
        return familyDao;
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return familyDao.getAllFamilies().stream()
                .filter(ind -> ind.countFamily() > count)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int count) {
        return familyDao.getAllFamilies().stream()
                .filter(ind -> ind.countFamily() < count)
                .collect(Collectors.toList());
    }

    public int countFamiliesWithMemberNumber(int number) {
        return (int) familyDao.getAllFamilies().stream()
                .filter(ind -> ind.countFamily() == number)
                .count();
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

    private boolean getOldYears(Human human, int count) {
        String dateInString = UtilsHuman.parseDateFromLongToString(human.getBirthDate());
        LocalDate date = LocalDate.parse(dateInString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Period period = Period.between(date, LocalDate.now());
        return (period.getYears() > count);
    }

    public void deleteAllChildrenOlderThen(int age) {
        getFamilyDao().getAllFamilies().forEach(family -> {
            List<Human> listOld = family.getChildren().stream()
                    .filter(human -> getOldYears(human, age))
                    .collect(Collectors.toList());
            listOld.forEach(family::deleteChild);
            familyDao.saveFamily(family);
        });
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public Set<Pet> getPets(int index) {
        if (familyDao.getAllFamilies().get(index).getPets().isEmpty())
            return Collections.emptySet();
        return familyDao.getAllFamilies().get(index).getPets();

    }

    public void addPet(int index, Pet pet) {
        familyDao.getAllFamilies().get(index).getPets().add(pet);
    }


}