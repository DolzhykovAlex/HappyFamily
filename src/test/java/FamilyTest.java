import baseClasses.families.Family;
import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.Woman;
import baseClasses.pets.Dog;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Begin test Class FamilyTest");
    }

    @Test
    public void addChildTest() {
        Man human1M = new Man("Alex", "Bal", 1983, 180);
        Woman human1W = new Woman("Sweet", "Wallet", 1984, 190);
        Man child2M = new Man("Dima", "Max", 2022, 10);
        Woman child2W = new Woman("Ira", "Max", 2023, 10);
        Family family = new Family(human1M, human1W);
        family.addChild(child2M);
        family.addChild(child2W);
        int n = family.getChildren().size();
        assertAll("Check addChild =================================================",
                () -> assertEquals(n, family.getChildren().size()),
                () -> assertEquals(child2W, family.getChildren().get(n - 1))
        );


    }

    @Test
    public void countFamilyTest() {
        Man human1M = new Man("Alex", "Bal", 1983, 180);
        Woman human1W = new Woman("Sweet", "Wallet", 1984, 190);
        Man child2M = new Man("Dima", "Max", 2022, 10);
        Woman child2W = new Woman("Ira", "Max", 2023, 10);
        Family family = new Family(human1M, human1W);
        family.addChild(child2M);
        family.addChild(child2W);
        //2 parents + 2 children expected == 4
        int expected = 4;
        assertEquals(expected, (family.countFamily()));
    }


    @Test
    public void deleteChildByIndexNegativeTest() {
        Man human1M = new Man("Alex", "Bal", 1983, 180);
        Woman human1W = new Woman("Sweet", "Wallet", 1984, 190);
        Man child2M = new Man("Dima", "Max", 2022, 10);
        Woman child2W = new Woman("Ira", "Max", 2023, 10);
        Family family = new Family(human1M, human1W);
        family.addChild(child2M);                                               // first add to index 0
        family.addChild(child2W);                                             // second add to index 1

        assertAll("Check delete by index Negative=================================================",
                () -> assertFalse(family.deleteChild(5)),                 // check right return of method deleteChild
                () -> assertEquals(2, family.getChildren().size())   // array length=2 after negative delete child

        );
    }

    @Test
    public void deleteChildByHumanNegativeTest() {
        Man human1M = new Man("Alex", "Bal", 1983, 180);
        Woman human1W = new Woman("Sweet", "Wallet", 1984, 190);
        Man child2M = new Man("Dima", "Max", 2022, 10);
        Woman child2W = new Woman("Ira", "Max", 2023, 10);
        Family family = new Family(human1M, human1W);
        Woman childNot = new Woman("Anya", "Max", 2020, 160);
        family.addChild(child2M);                                               // first add to index 0
        family.addChild(child2W);                                             // second add to index 1

        assertAll("Check delete by Class Negative =================================================",
                () -> assertFalse(family.deleteChild(childNot)),                 // check right return of method deleteChild
                () -> assertEquals(2, family.getChildren().size())   // array length=2 after negative delete child

        );
    }

    @Test
    public void deleteChildByHumanPositiveTest() {
        Man human1M = new Man("Alex", "Bal", 1983, 180);
        Woman human1W = new Woman("Sweet", "Wallet", 1984, 190);
        Man child2M = new Man("Dima", "Max", 2022, 10);
        Woman child2W = new Woman("Ira", "Max", 2023, 10);
        Family family = new Family(human1M, human1W);
        family.addChild(child2M);                                               // first add to index 0
        family.addChild(child2W);                                             // second add to index 1

        assertAll("Check delete by Class Positive=================================================",
                () -> assertTrue(family.deleteChild(child2M)),                 // check right return of method deleteChild
                () -> assertEquals(1, family.getChildren().size())   // array length=1 after  delete child

        );
    }

    @Test
    public void deleteChildByIndexPositiveTest() {
        Man human1M = new Man("Alex", "Bal", 1983, 180);
        Woman human1W = new Woman("Sweet", "Wallet", 1984, 190);
        Man child2M = new Man("Dima", "Max", 2022, 10);
        Woman child2W = new Woman("Ira", "Max", 2023, 10);
        Family family = new Family(human1M, human1W);
        family.addChild(child2M);                                // first add to index 0
        family.addChild(child2W);                               // second add to index 1
        assertAll("Check delete by Index Positive=================================================",
                () -> assertTrue(family.deleteChild(0)),                  // check right return of method deleteChild
                () -> assertEquals(1, family.getChildren().size())   // array length=1 after  delete child

        );
    }

    @Test
    void toStringTest() {
        String familyToString1 = "mother= Alex Bal, father= Sweet Wallet, NO children, NO PET.";
        String familyToString2 = "mother= Max Min, father= Fusion Max, NO children\n" +
                "Dog (nickname='Mars ', age=1, trickLevel=2, habits= [Play, Sleep, Eat], has species: Dog canFly= false, hasFur= true, numberOfLegs= 4)";
        Man human1M = new Man("Alex", "Bal", 1983, 180);
        Woman human1W = new Woman("Sweet", "Wallet", 1984, 190);
        Man human2M = new Man("Max", "Min", 1999, 150);
        Woman human2W = new Woman("Fusion", "Max", 1997, 160, new String[]{"day 1 Task1", "day2 Task2", "day 3 Task3", "day4 Task4", "day 5 Task5,"});
        Family family1 = new Family(human1M, human1W);
        Family family2 = new Family(human2M, human2W, new HashSet<>(Arrays.asList(new Dog("Mars ", 1, 2, new HashSet<>(Arrays.asList("Play", "Eat", "Sleep"))))));
        assertAll("Check toString Family  Class =================================================",
                () -> assertEquals(familyToString1, family1.toString()),
                () -> assertEquals(familyToString2, family2.toString())

        );
    }

    @Test
    void equalsPositiveTest() {
        Man child2M = new Man("Dima", "Max", 2022, 10);
        Woman child1M = new Woman("Ima", "Max", 2022, 10, new String[]{"day1", "day2"});
        Family family = new Family(child2M, child1M);
        Family family1 = new Family(child2M, child1M, new HashSet<>(Arrays.asList(new Dog("Mars ", 1, 2, new HashSet<>(Arrays.asList("Play", "Eat", "Sleep"))))));
        assertTrue(family.equals(family1));

    }

    @Test
    void hashPositiveTest() {
        Man child2M = new Man("Dima", "Max", 2022, 10);
        Woman child1M = new Woman("Ima", "Max", 2022, 10, new String[]{"day1", "day2"});
        Family family = new Family(child2M, child1M);
        Family family1 = new Family(child2M, child1M, new HashSet<>(Arrays.asList(new Dog("Mars ", 1, 2, new HashSet<>(Arrays.asList("Play", "Eat", "Sleep"))))));
        assertEquals(family.hashCode(), family1.hashCode());

    }


    @Test
    void hashNegativeTest() {
        Human child3M = new Human("Dim", "Max", 2022, 10);
        Human child5M = new Human("Dima", "Maxi", 2020, 10);
        Human expectedHuman = new Human("Dima", "Max", 2022, 10);
        Family family = new Family(child3M, expectedHuman);
        Family family1 = new Family(child5M, expectedHuman, new HashSet<>());
        Family family2 = new Family(expectedHuman, child3M);
        assertAll("Check Family HashCode Negative=================================================",
                () -> assertTrue(family.hashCode() != family1.hashCode()),
                () -> assertTrue(family.hashCode() != family2.hashCode())
        );
    }

    @Test
    void equalsNegativeTest() {
        Man child3M = new Man("Dim", "Max", 2022, 10);
        Man child5M = new Man("Dima", "Maxi", 2020, 10);
        Human expectedHuman = new Human("Dima", "Max", 2022, 10);
        Family family = new Family(child3M, expectedHuman);
        Family family1 = new Family(child5M, expectedHuman, new HashSet<>());
        Family family2 = new Family(expectedHuman, child3M);
        assertAll("Check Family equals Negative=================================================",
                () -> assertFalse(family.equals(family1)),
                () -> assertFalse(family.equals(family2))
        );
    }


    @AfterAll
    static void afterAll() {
        System.out.println(" test complete in class FamilyTest ");
    }
}