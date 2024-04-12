package baseClasses.menu;

public class Utils {
    static public boolean isInteger(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '-') {
                System.out.println("You did not enter  a number or your number is less then 0");
                return false;
            }
            if (Character.digit(s.charAt(i), 10) < 0) {
                System.out.println("You did not enter  a number ");
                return false;
            }
        }
        return true;
    }

    static public boolean correctValue(String string, int n) {
        if (string.isEmpty()) {
            System.out.println("You enter empty value");
            return false;
        } else if (string.length() > n) {
            System.out.println("You enter to many signs ");
            return false;
        } else {
            return isInteger(string);
        }
    }

}
