package baseClasses.humans;


import baseClasses.Family;
import baseClasses.enums.DayOfWeek;
import baseClasses.pets.Pet;

import java.util.*;

public class Human {


    private String name;
    private String surname;
    private int year;
    private int iq;
    Family family;
    private Map<DayOfWeek, String> schedule = new HashMap<>();

    {
        for (DayOfWeek x : DayOfWeek.values())
            this.schedule.put(x, " Empty day");
    }

    private Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(HashMap<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }


    public Human(String name, String surname, int year, int iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }

    public Human(String name, String surname, int year, int iq, HashMap<DayOfWeek, String> map) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = map;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && Objects.equals(name, human.name) && Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name= '").append(name).append("' surname= '")
                .append(surname).append("', year= ").append(year).append(", IQ= ").append(iq).append(", schedule=").append(" [");
        for (DayOfWeek x : DayOfWeek.values()) {
            String s = String.format("\n  Task for   %9s = '%s' ", x.getEnumValueToString(), schedule.get(x));
            stringBuilder.append(s);
        }
        return String.valueOf(stringBuilder.append("]"));
    }

    public void feedPet(boolean timeToFeed) {
        if (family.checkPet()) {
            Random random = new Random();
            for (Pet x : this.family.getPets()) {
                int checkTry = random.nextInt(101);
                if ((!timeToFeed) && (x.getTrickLevel() < checkTry)) {
                    System.out.println("Хм... чи  годувати ['" + x.getNickname() + "'] Думаю да");
                } else System.out.println(" Думаю, ['" + x.getNickname() + "'] не голодний");
            }
        }
    }


    public void greetPet() {
    }

    public void describePet() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }


    public void setSchedule() {
        Scanner scanner = new Scanner(System.in);
        String s;
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.print("Enter your task for ");
            System.out.println(day.getEnumValueToString());
            s=scanner.nextLine();
            if (!s.isEmpty())
            schedule.put(day, s);
            else schedule.put(day, "Empty day");
        }
    }

    public void printSchedule() {
        for (DayOfWeek x : DayOfWeek.values()) {
            System.out.printf("Task for   %9s = '%s' \n", x.getEnumValueToString(), schedule.get(x));
        }
    }
}
