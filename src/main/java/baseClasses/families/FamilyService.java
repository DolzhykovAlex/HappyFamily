package baseClasses.families;

import baseClasses.enums.DayOfWeek;
import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.UtilsHuman;
import baseClasses.humans.Woman;
import baseClasses.interfasesOfProgect.Dao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import baseClasses.pets.Dog;
import baseClasses.pets.DomesticCat;
import baseClasses.pets.Pet;
import exeptions.FamilyOverflowException;


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
                .forEach(ind -> System.out.println(" Family index= " + (ind + 1) + " {" + familyDao.getFamilyByIndex(ind) + "}\n"));
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

    public void bornChild(Family family, String manName, String womenName) throws FamilyOverflowException {
        System.out.println("Максимальний розмір родини= 4 людини. Зрараз --  " + family.countFamily() + " людини та ми спробуємо її збільшити");
        if (family.countFamily() == 4) {
            System.out.println("Дитину не буде додано".toUpperCase());
            throw new FamilyOverflowException("The family couldn't be more than 4 people ");
        } else {
            Human child = family.bornChild(family);
            if (child.getClass() == Man.class) child.setName(manName);
            else child.setName(womenName);
            family.addChild(child);
            System.out.println("Дитину було додано");
            familyDao.saveFamily(family);
        }
    }

    public void adoptChild(Family family, Human human) throws FamilyOverflowException {
        System.out.println("Максимальний розмір родини= 4 людини. Зрараз --  " + family.countFamily() + " людини та ми спробуємо її збільшити");
        if (family.countFamily() == 4) {
            System.out.println("Дитину не буде додано".toUpperCase());
            throw new FamilyOverflowException("The family couldn't be more than 4 people ");
        } else {
            family.addChild(human);
            System.out.println("Дитину було додано");
            familyDao.saveFamily(family);
        }
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

    public int countFamiliesInBase() {
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

    public void fillBase() {
        Dog dog = new Dog("Spin", 4, 34, new HashSet<>(Arrays.asList("sleep", "eat")));
        DomesticCat cat = new DomesticCat("Black", 4, 34, new HashSet<>(Arrays.asList("sleep", "eat")));

        Man human1M = new Man("Obama", "Bal", 234234, 180);
        human1M.setScheduleDay(DayOfWeek.MONDAY, "FOOTbAll");
        human1M.setScheduleDay(DayOfWeek.SUNDAY, "Tennis");
        Woman human1W = new Woman("Sweet", "Bal", "11/11/1983", 190);
        human1W.setScheduleDay(DayOfWeek.MONDAY, "swimming");
        human1W.setScheduleDay(DayOfWeek.SUNDAY, "Cafe");
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
        family4.getPets().add(dog);
        family4.getPets().add(cat);
        familyDao.saveFamily(family1);
        familyDao.saveFamily(family2);
        familyDao.saveFamily(family3);
        familyDao.saveFamily(family4);
    }

    public void loadData(List<Family> families) throws IOException {
        familyDao.loadData(families);
    }

    public void uploadData()  {
          familyDao.uploadData();
    }


}