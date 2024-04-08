import baseClasses.families.CollectionFamilyDao;
import baseClasses.families.Family;
import baseClasses.families.FamilyService;
import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.Woman;
import baseClasses.pets.Dog;
import baseClasses.pets.Pet;


import org.junit.jupiter.api.Test;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyServiceTest {


    private final FamilyService fs = new FamilyService();

    public FamilyServiceTest() {
        new CollectionFamilyDao();
    }


    @Test
    public void getAllFamiliesTest() {
        assertEquals(fs.getAllFamilies(), fs.getAllFamilies());
    }

    @Test
    public void displayAllFamiliesTest() {
        String expected = "Family index= 0 {mother= Sweet Bal, father= Obama Bal, NO children, NO PET.}\n" +
                "Family index= 1 {mother= Hilary Bush, father= Jorge Bush, NO children, NO PET.}\n" +
                "Family index= 2 {mother= Agata Tyson, father= Mike Tyson, NO children, NO PET.}\n" +
                "Family index= 3 {mother= Agata Black, father= Alex Black, NO children, NO PET.}\n";
        StringBuilder actual = new StringBuilder();
        IntStream.range(0, fs.getAllFamilies().size())
                .forEach(ind -> actual.append("Family index= " + ind + " {" + fs.getFamilyById(ind) + "}\n"));
        assertEquals(expected, String.valueOf(actual));
    }

    @Test
    public void getFamiliesBiggerThanTest() {
        int count = 2;
        Man human1M = new Man("Obama", "Bal", "11/12/1983", 180);
        fs.getFamilyById(0).addChild(human1M);
        List<Family> ls = fs.getAllFamilies().stream()
                .filter(ind -> ind.countFamily() > count)
                .collect(Collectors.toList());
        assertAll("Check Family Bigger then Test =================================================",
                () -> assertEquals(1, ls.size()),
                () -> assertEquals(fs.getFamilyById(0), ls.get(0)));

    }

    @Test
    public void getFamiliesLessThanTest() {
        int count = 3;
        Man human1M = new Man("Obama", "Bal", "11/12/1983", 180);
        fs.getFamilyById(0).addChild(human1M);
        List<Family> expected = new ArrayList<>(Arrays.asList(fs.getFamilyById(1), fs.getFamilyById(2), fs.getFamilyById(3)));
        List<Family> ls = fs.getAllFamilies().stream()
                .filter(ind -> ind.countFamily() < count)
                .collect(Collectors.toList());
        assertAll("Check Family Less then Test =================================================",
                () -> assertEquals(3, ls.size()),
                () -> assertEquals(expected, ls));
    }

    @Test
    public void countFamiliesWithMemberNumberTest() {
        Man human1M = new Man("Obama", "Bal", "11/12/1983", 180);
        fs.getAllFamilies().get(0).addChild(human1M);
        int count = 2;
        int actual = (int) fs.getAllFamilies().stream()
                .filter(ind -> ind.countFamily() == count)
                .count();
        assertEquals(3, actual);

    }

    @Test
    public void createNewFamilyTest() {
        Man human1M = new Man("Alexey", "Bal", 1983, 180);
        Woman human1W = new Woman("Sweet", "Wallet", 1984, 190);
        Family family1 = new Family(human1W, human1M);
        System.out.println("Create new Family successful " + !fs.getFamilyDao().saveFamily(family1));
        int count = fs.getAllFamilies().size();
        assertAll("Check create Family  Test =================================================",
                () -> assertEquals(5, count),
                () -> assertTrue(fs.getFamilyDao().saveFamily(family1)),
                () -> assertEquals(family1, fs.getFamilyDao().getFamilyByIndex(count - 1)));
    }

    @Test
    public void deleteFamilyByIndexTest() {
        Family family = fs.getFamilyDao().getFamilyByIndex(3);
        fs.deleteFamilyByIndex(0);
        fs.deleteFamilyByIndex(0);
        fs.deleteFamilyByIndex(0);
        assertEquals(family, fs.getAllFamilies().get(0));
    }

    @Test
    public void bornChildTest() {
        Man human1M = new Man("Alexwwww", "Bal", "11/11/1983", 180);
        Woman human1W = new Woman("Sweeeeet", "Wallet", "12/12/1984", 190);
        Family family1 = new Family(human1W, human1M);
        Human child = family1.bornChild(family1);
        family1.addChild(child);
        fs.getFamilyDao().saveFamily(family1);
        int count = fs.getAllFamilies().size();
        if (child.getClass() == Man.class)
            assertAll("Check born child Man  Test =================================================",
                    () -> assertEquals(5, count),
                    () -> assertEquals(family1, fs.getFamilyById(count - 1)));
        else if (child.getClass() == Woman.class)
            assertAll("Check born child Women  Test =================================================",
                    () -> assertEquals(5, count),
                    () -> assertEquals(family1, fs.getFamilyById(count - 1)));
        else fail();
    }

    @Test
    public void adoptChildTest() {
        Man human1M = new Man("Obama", "Bal", "12/12/1983", 180);
        Woman human1W = new Woman("Sweet", "Bal", "11/11/1983", 190);
        Family family = new Family(human1W, human1M);
        Man human2M = new Man("Jorge", "Bush", "10/10/1983", 140);
        fs.adoptChild(family, human2M);
        fs.getFamilyDao().saveFamily(family);
        int count = fs.getAllFamilies().size();
        assertAll("Check adoptChildTest  =================================================",
                () -> assertEquals(4, count),
                () -> assertEquals(family, fs.getFamilyById(0)));
    }

    @Test
    public void deleteAllChildrenOlderThenTest() {
        int age = 1;
        Man human1M = new Man("Obama", "Bal", "12/3/2024", 180);
        Man human2M = new Man("Obama", "Bal", "12/12/2021", 180);
        Woman human1W = new Woman("Sweet", "Bal", "11/11/1983", 190);
        fs.getFamilyById(0).addChild(human1M);
        fs.getFamilyById(0).addChild(human2M);
        fs.getFamilyById(1).addChild(human1W);
        fs.deleteAllChildrenOlderThen(age);
        assertAll("Check  deleteAllChildrenOlderThenTest  =================================================",
                () -> assertEquals(3, fs.getFamilyById(0).countFamily()),
                () -> assertEquals(2, fs.getFamilyById(1).countFamily()));
    }


    @Test
    public void countTest() {
        assertEquals(4, fs.getAllFamilies().size());
    }

    @Test
    public void getFamilyByIdTest() {
        Man human1M = new Man("Obama", "Bal", "12/12/1983", 180);
        Woman human1W = new Woman("Sweet", "Bal", "11/11/1983", 190);
        Family family1 = new Family(human1W, human1M);
        assertEquals(family1, fs.getFamilyById(0));
    }


    @Test
    public void getPetsTest() {
        Dog pet = new Dog("Rock", 5, 75, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));
        fs.getFamilyById(0).getPets().add(pet);
        Set<Pet> setPet = fs.getPets(0);
        assertEquals(setPet, fs.getPets(0));
    }


    @Test
    public void addPetTest() {
        Dog pet = new Dog("Rock", 5, 75, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));
        fs.addPet(1, pet);
        assertTrue(fs.getFamilyById(1).getPets().contains(pet));
    }
}