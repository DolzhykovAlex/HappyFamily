import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.UtilsHuman;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;


public class HumanTest {

    @Test
    public void toStringTest() {
        String expected = "Name= 'Alex' surname= 'Bal', birthDate= 21/05/1975, IQ= 180, schedule= [\n"
                + "  Task for      Monday = 'Empty day' \n"
                + "  Task for     Tuesday = 'Empty day' \n"
                + "  Task for   Wednesday = 'Empty day' \n"
                + "  Task for    Thursday = 'Empty day' \n"
                + "  Task for      Friday = 'Empty day' \n"
                + "  Task for    Saturday = 'Empty day' \n"
                + "  Task for      Sunday = 'Empty day' ]";
        Man human1M = new Man("Alex", "Bal", "21/05/1975", 180);
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
        Human child3M = new Human("Dim", "Max", 1701640800, 10);
        Human child4M = new Human("Dima", "Maxi", 1701640800, 10);
        Human child5M = new Human("Dima", "Maxi", 1701640800, 10);
        Human expectedHuman = new Human("Dima", "Max", 1701640800, 10);
        assertAll("Check Human HashCode Negative=================================================",
                () -> assertTrue(expectedHuman.hashCode() != child3M.hashCode()),     // different name
                () -> assertTrue(expectedHuman.hashCode() != child4M.hashCode()),     // different surname
                () -> assertTrue(expectedHuman.hashCode() != child5M.hashCode()));    // different year
    }

    @Test
    void equalsNegativeTest() {
        Human child3M = new Human("Dim", "Max", 1701640800, 10);
        Human child4M = new Human("Dima", "Maxi", 1701640800, 10);
        Human child5M = new Human("Dima", "Maxi", 1701640800, 10);
        Human expectedHuman = new Human("Dima", "Max", 1701640800, 10);
        assertAll("Check Human equals Negative=================================================",
                () -> assertNotEquals(expectedHuman, child3M),     // different name
                () -> assertNotEquals(expectedHuman, child4M),     // different surname
                () -> assertNotEquals(expectedHuman, child5M));    // different year
    }

    @Test
    void describeAge() {

        String expected = "0 years 0 months 0 days";
        String dateInString = UtilsHuman.parseDateFromLongToString(1701640800);
        LocalDate date = LocalDate.parse(dateInString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Period period = Period.between(date, LocalDate.of(2023, 12, 4));
        String actual = period.getYears() + " years "
                + period.getMonths() + " months "
                + period.getDays() + " days";
        assertEquals(expected, actual);

    }


}
