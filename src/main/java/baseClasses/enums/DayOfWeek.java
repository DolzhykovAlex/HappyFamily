package baseClasses.enums;

public enum DayOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private final String enumValueToString;

    DayOfWeek(String value) {
        this.enumValueToString = value;
    }


    public String getEnumValueToString() {
        return this.enumValueToString;
    }


}
