import baseClasses.humans.UtilsHuman;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class HumanUtilsTest {

    @Test
    void parseDateFromLongToStringTest() {
        String expected = "04/12/2023";
        assertEquals(expected, UtilsHuman.parseDateFromLongToString(1701640800));

    }

    @Test
    void parseDateFromStringToLong() {
        long expected = 1701640800L;
        assertEquals(expected, UtilsHuman.parseDateFromStringToLong("04/12/2023"));
    }

    @Test
    void describeAge() {

        String expected = "0 years 0 months 0 days";
        String dateInString = UtilsHuman.parseDateFromLongToString(1701640800);
        LocalDate date = LocalDate.parse(dateInString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Period period = Period.between(date,  LocalDate.of(2023,12,4));
        String actual = period.getYears() + " years "
                + period.getMonths() + " months "
                + period.getDays() + " days";
        assertEquals(expected, actual);

    }
}
