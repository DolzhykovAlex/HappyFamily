package baseClasses.enums;

public enum Species {

    DOMESTICCAT("DomesticCat", false, true, 4),
    DOG("Dog", false, true, 4),
    FISH("Fish", false, false, 0),
    ROBOCAT("RoboCat", false, false, 4),
    UNKNOWN("Unknown");


    private boolean canFly;
    private boolean hasFur;
    private int numberOfLegs;
    private final String enumNameToString;

    Species(String enumNameToString, boolean canFly, boolean hasFur, int numberOfLegs) {
        this.enumNameToString = enumNameToString;
        this.canFly = canFly;
        this.hasFur = hasFur;
        this.numberOfLegs = numberOfLegs;
    }

    Species(String enumValueToString) {
        this.enumNameToString = enumValueToString;
    }

    @Override
    public String toString() {
        return
                enumNameToString +
                        " canFly= " + canFly +
                        ", hasFur= " + hasFur +
                        ", numberOfLegs= " + numberOfLegs;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public String getEnumValueToString() {
        return this.enumNameToString;
    }


}
