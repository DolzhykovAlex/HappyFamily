package baseClasses.humans;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class UtilsHuman {

    static public void describeAge(long dateIn) {
        String dateInString = parseDateFromLongToString(dateIn);
        LocalDate date = LocalDate.parse(dateInString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Period period = Period.between(date, LocalDate.now());
        System.out.println(period.getYears() + " years "
                + period.getMonths() + " months "
                + period.getDays() + " days");
    }

    static public String parseDateFromLongToString(long longTime) {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date(longTime * 1000));
    }

    static public long parseDateFromStringToLong(String dateIn) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        try {
            date = formatter.parse(dateIn);
        } catch (ParseException e) {
            System.out.println(" Incorrect birthday in");
            throw new RuntimeException(e);
        }
        return date.getTime() / 1000;
    }
}
