package baseClasses.humans;


import baseClasses.Family;
import baseClasses.enums.DayOfWeek;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Human {


    private String name;
    private String surname;
    private int year;
    private int iq;
    Family family;
    private String[] schedule = new String[7];


    public Human(String name, String surname, int year, int iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }

    public Human(String name, String surname, int year, int iq, String[] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
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
                .append(surname).append("', year= ").append(year).append(", IQ= ").append(iq).append(", schedule=").append("[");
        for (DayOfWeek day : DayOfWeek.values()) {
            stringBuilder.append(day.getEnumValueToString()).append("= ");
            if (day.ordinal() >= schedule.length) stringBuilder.append("Empty day| ");
            else if ((null == schedule[day.ordinal()]) || (schedule[day.ordinal()].isEmpty()))
                stringBuilder.append("Empty day| ");
            else stringBuilder.append(schedule[day.ordinal()]).append("| ");
        }
        return String.valueOf(stringBuilder.append("]"));
    }

    public boolean feedPet(boolean timeToFeed) {
        if (null == family.getPet()) {
            System.out.println("У мне нема тварини");
            return false;
        }
        if (!timeToFeed) {
            Random random = new Random();
            int check = random.nextInt(101);
            if (family.getPet().getTrickLevel() > check) {
                System.out.println("Хм... чи  годувати  [" + family.getPet().getNickname() + "] Думаю да");
                return true;
            }
        } else System.out.println(" Думаю, " + family.getPet().getNickname() + " не голодний");
        return false;
    }

    public void greetPet() {}

    public void describePet() {
       }


    public void setName(String name) {
        this.name = name;
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

    public String[] getSchedule() {
        return schedule;
    }

    public String getScheduleDay(int i) {
        if (i >= schedule.length) return " Empty day";
        return schedule[i];
    }


    public void setSchedule(String[] schedule) {
        this.schedule = schedule;
    }


    public void setSchedule() {
        Scanner scanner = new Scanner(System.in);
        this.schedule = new String[7];
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.print("Enter your task for ");
            System.out.println(day.getEnumValueToString());
            schedule[day.ordinal()] = scanner.nextLine();
        }
    }

    public void getScheduleToPrint() {
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.print(" Your task for ");
            System.out.println(day.getEnumValueToString());
            System.out.println(getScheduleDay(day.ordinal()));

        }
    }

    public String getName() {
        if (name == null) return " UNKNOWN";
        return name;
    }


}
