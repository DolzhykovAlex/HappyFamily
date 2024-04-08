package baseClasses.humans;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;


public class UtilsHuman {


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
