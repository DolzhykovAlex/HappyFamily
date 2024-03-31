import baseClasses.enums.DayOfWeek;
import baseClasses.humans.Human;
import baseClasses.humans.Man;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class HumanTest {

    @Test
    public void toStringTest() {
        String expected = new String("Name= 'Alex' surname= 'Bal', year= 1983, IQ= 180, schedule= [\n"
                + "  Task for      Monday = ' Empty day' \n"
                + "  Task for     Tuesday = ' Empty day' \n"
                + "  Task for   Wednesday = ' Empty day' \n"
                + "  Task for    Thursday = ' Empty day' \n"
                + "  Task for      Friday = ' Empty day' \n"
                + "  Task for    Saturday = ' Empty day' \n"
                + "  Task for      Sunday = ' Empty day' ]");
        Man human1M = new Man("Alex", "Bal", 1983, 180);
        assertEquals(expected, human1M.toString());
    }


    @Test
    void equalsPositiveTest() {
        Human child2M = new Human("Dima", "Max", 2022, 10);
        Human child1M = new Human("Dima", "Max", 2022, 10);
        assertTrue(child2M.equals(child1M));

    }

    @Test
    void hashPositiveTest() {
        Human child2M = new Human("Dima", "Max", 2022, 10);
        Human child1M = new Human("Dima", "Max", 2022, 10);
        assertEquals(child2M.hashCode(), child1M.hashCode());

    }


    @Test
    void hashNegativeTest() {
        Human child3M = new Human("Dim", "Max", 2022, 10);
        Human child4M = new Human("Dima", "Maxi", 2022, 10);
        Human child5M = new Human("Dima", "Maxi", 2020, 10);
        Human expectedHuman = new Human("Dima", "Max", 2022, 10);
        assertAll("Check Human HashCode Negative=================================================",
                () -> assertTrue(expectedHuman.hashCode() != child3M.hashCode()),     // different name
                () -> assertTrue(expectedHuman.hashCode() != child4M.hashCode()),     // different surname
                () -> assertTrue(expectedHuman.hashCode() != child5M.hashCode()));    // different year
    }

    @Test
    void equalsNegativeTest() {
        Human child3M = new Human("Dim", "Max", 2022, 10);
        Human child4M = new Human("Dima", "Maxi", 2022, 10);
        Human child5M = new Human("Dima", "Maxi", 2020, 10);
        Human expectedHuman = new Human("Dima", "Max", 2022, 10);
        assertAll("Check Human equals Negative=================================================",
                () -> assertNotEquals(expectedHuman, child3M),     // different name
                () -> assertNotEquals(expectedHuman, child4M),     // different surname
                () -> assertNotEquals(expectedHuman, child5M));    // different year
    }


}
