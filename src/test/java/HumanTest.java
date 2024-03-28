import baseClasses.enums.DayOfWeek;
import baseClasses.humans.Human;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HumanTest {

    @Test
    public void toStringTest() {
        Human child2M = new Human("Dima", "Max", 2022, 10);
        Human human2M = new Human("Alex", "Bal", 1983, 180, new String[]{"day1", "day2"});
        Human human1M = new Human("Fusion", "Max", 1997, 160, new String[]{"day 1 Task1", "day2 Task2", "day 3 Task3", "day4 Task4", "day 5 Task5,"});
        Human[] humansArray = new Human[]{child2M, human2M, human1M};
        for (int i = 0; i < 3; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Name= '").append(humansArray[i].getName()).append("' surname= '")
                    .append(humansArray[i].getSurname()).append("', year= ").append(humansArray[i].getYear()).append(", IQ= ").append(humansArray[i].getIq()).append(", schedule=").append("[");
            for (DayOfWeek day : DayOfWeek.values()) {
                stringBuilder.append(day.getEnumValueToString()).append("= ");
                if (day.ordinal() >= humansArray[i].getSchedule().length) stringBuilder.append("Empty day| ");
                else if (null == humansArray[i].getScheduleDay(day.ordinal()) || (humansArray[i].getScheduleDay(day.ordinal()).isEmpty()))
                    stringBuilder.append("Empty day| ");
                else stringBuilder.append(humansArray[i].getScheduleDay(day.ordinal())).append("| ");
            }
            stringBuilder.append("]");
            assertEquals(stringBuilder.toString(), humansArray[i].toString());
        }
    }

    @Test
    void equalsPositiveTest() {
        Human child2M = new Human("Dima", "Max", 2022, 10);
        Human child1M = new Human("Dima", "Max", 2022, 10, new String[]{"day1", "day2"});
        assertTrue(child2M.equals(child1M));

    }

    @Test
    void hashPositiveTest() {
        Human child2M = new Human("Dima", "Max", 2022, 10);
        Human child1M = new Human("Dima", "Max", 2022, 10, new String[]{"day1", "day2"});
        assertEquals(child2M.hashCode(), child1M.hashCode());

    }


    @Test
    void hashNegativeTest() {
        Human child3M = new Human("Dim", "Max", 2022, 10);
        Human child4M = new Human("Dima", "Maxi", 2022, 10);
        Human child5M = new Human("Dima", "Maxi", 2020, 10);
        Human expectedHuman = new Human("Dima", "Max", 2022, 10, new String[]{"day1", "day2"});
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
        Human expectedHuman = new Human("Dima", "Max", 2022, 10, new String[]{"day1", "day2"});
        assertAll("Check Human equals Negative=================================================",
                () -> assertNotEquals(expectedHuman, child3M),     // different name
                () -> assertNotEquals(expectedHuman, child4M),     // different surname
                () -> assertNotEquals(expectedHuman, child5M));    // different year
    }


}
