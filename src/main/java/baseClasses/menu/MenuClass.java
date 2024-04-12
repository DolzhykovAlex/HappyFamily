package baseClasses.menu;

import baseClasses.families.FamilyController;
import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.UtilsHuman;
import baseClasses.humans.Woman;

import java.time.LocalDate;
import java.util.*;

public class MenuClass {
    static final String[] mainMenu = {"1. Заповнити базу тестовими даними.",
            "2. Відобразити весь список сімей.",
            "3. Відобразити список сімей, де кількість людей більша за задану.",
            "4. Відобразити список сімей, де кількість людей менша за задану.",
            "5. Підрахувати кількість сімей, де кількість членів дорівнює заданої кількості.",
            "6. Створити нову родину.",
            "7. Видалити сім'ю за індексом із загального списку.",
            "8. Редагувати сім'ю за індексом із загального списку(додати дитину).",
            "9. Видалити всіх дітей старше заданного віку.",
            "10.Вихід."};

    static final String[] newFamily = {"\n Запитати ім'я матері",
            "\nВведіть прізвище матері",
            "\nВведіть день народження матері",
            "\nВведіть місяць народження матері",
            "\nВведіть рік народження матері ",
            "\nВведіть iq матері",
            "\nВведіть ім'я батька",
            "\nВведіть прізвище батька",
            "\nВведіть день народження батька",
            "\nВведіть місяць народження батька",
            "\nВведіть рік народження батька",
            "\nВведіть iq батька"};

    static public void mainManu() {
        FamilyController fc = new FamilyController();
        System.out.println();
        boolean powerON = true;
        while (powerON) {
            printMainMenu();
            System.out.println("Please enter number of menu".toUpperCase());
            int choice = getValueFromKeyboardInt(2);
            if (choice > 10)
                System.out.println("Введено занадто велике число спробуйте ще раз");
            else {
                answerMainManu(choice);
                switch (choice) {
                    case 1: {
                        System.out.println("   Connect Test Database Done".toUpperCase());
                        fc.fillBase();
                        continue;
                    }
                    case 2: {
                        System.out.println("Display Database".toUpperCase());
                        if (dataBaseConnectCheck(fc))
                            fc.displayAllFamilies();
                        break;
                    }
                    case 3: {
                        System.out.println("Family bigger then entered".toUpperCase());
                        if (dataBaseConnectCheck(fc)) {
                            System.out.println("Enter number of people");
                            System.out.println(fc.getFamiliesBiggerThan(getValueFromKeyboardInt(2)));
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("Family Less then entered".toUpperCase());
                        if (dataBaseConnectCheck(fc)) {
                            System.out.println("Enter number of people");
                            System.out.println(fc.getFamiliesLessThan(getValueFromKeyboardInt(2)));
                        }
                        break;
                    }
                    case 5: {
                        System.out.println("Count families with entered number of peoples".toUpperCase());
                        if (dataBaseConnectCheck(fc)) {
                            System.out.println("Enter number of people");
                            System.out.println("Amount of families = " + fc.countFamiliesWithMemberNumber(getValueFromKeyboardInt(2)));
                        }
                        break;
                    }
                    case 6: {
                        System.out.println("Create new family".toUpperCase());
                        Human[] humans = parentsInfo();
                        System.out.println("Created New Family--" + fc.createNewFamily(humans[0], humans[1]));
                        break;
                    }
                    case 7: {
                        System.out.println("Delete family with entered id".toUpperCase());
                        fc.deleteFamilyByIndex(getValueFromKeyboardInt(2) - 1);
                        break;
                    }
                    case 8: {
                        System.out.println("Refactor family (add child)".toUpperCase());
                        if (dataBaseConnectCheck(fc))
                            submenuAddChild(fc);
                        break;
                    }
                    case 9: {
                        System.out.println("Видалити всіх дітей старше заданного віку.".toUpperCase());
                        if (dataBaseConnectCheck(fc))
                            fc.deleteAllChildrenOlderThen(getValueFromKeyboardInt(2));
                        break;
                    }
                    case 10:
                        powerON = false;
                       

                }
            }
        }
    }

    private static Human[] parentsInfo() {
        Man father = new Man("", "", 0, 0);
        Woman mother = new Woman("", "", 0, 0);
        System.out.println(newFamily[0]);
        mother.setName(enterString());
        System.out.println(newFamily[1]);
        mother.setSurname(enterString());
        mother.setBirthDate(checkRightDate("матері"));
        mother.setBirthDate(checkIQ("матері"));
        //-------------------------------------------------
        System.out.println(newFamily[6]);
        father.setName(enterString());
        System.out.println(newFamily[7]);
        father.setSurname(enterString());
        father.setBirthDate(checkRightDate("батька"));
        father.setIq(checkIQ("батька"));
        return new Human[]{mother, father};
    }

    static public int getValueFromKeyboardInt(int n) {
        String string;
        do {
            string = enterString();
        } while (!Utils.correctValue(string, n));
        return Integer.parseInt(string);
    }

    public static void printMainMenu() {
        System.out.println("Головне меню".toUpperCase());
        Arrays.stream(mainMenu).forEach(System.out::println);
    }

    static public String enterString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    static public void answerMainManu(int i) {
        System.out.print(("Ваш вибір--" + mainMenu[i - 1].toUpperCase() + " !!!!!!!!\n"));
    }

    static public boolean dataBaseConnectCheck(FamilyController fc) {
        if ((null == fc) || (fc.count() == 0)) {
            System.out.println("DataBase not connected");
            return false;
        }
        return true;
    }

    static void submenuAddChild(FamilyController fc) {
        do {
            System.out.println("Choose your way \n"
                    + "1.Народити дитину \n"
                    + "2.Усиновити дитину\n"
                    + "3.Вихід в головне меню\n");
            int choice = getValueFromKeyboardInt(1);
            if (choice == 3) break;
            int id;
            do {
                System.out.println("Enter Family ID in range from 1 to " + fc.count());
                id = getValueFromKeyboardInt(2) - 1;
            } while (id >= fc.count() || (id < 0));
            if (choice == 1) {
                System.out.println("Enter name for Boy");
                String nameBoy = enterString();
                System.out.println("Enter name for Girl");
                String nameGirl = enterString();
                fc.bornChild(fc.getFamilyById(id), nameBoy, nameGirl);
                break;
            } else if (choice == 2) {
                Human child = new Human("", "", 0, 0);
                System.out.println("\n Введіть Ім'я дитини");
                child.setName(enterString());
                System.out.println("\n Введіть прізвище дитини");
                child.setSurname(enterString());
                child.setBirthDate(checkRightDate("дитини"));
                child.setIq(checkIQ("дитини"));
                fc.adoptChild(fc.getFamilyById(id), child);
                break;
            }
        } while (true);
    }

    static public long checkRightDate(String target) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> monthContains = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
        int year;
        int month;
        int day;

        do {
            System.out.println("\n Введіть рік народження " + target);
            year = (getValueFromKeyboardInt(4));
            if ((year <= LocalDate.now().getYear()) && (year > 1924)) {
                break;
            }
            System.out.println("Помилка, спробуйте ще раз");

        } while (true);

        do {
            System.out.println("\nВведіть місяць народження " + target);
            month = (getValueFromKeyboardInt(2));
            if ((month > 0) && (month < 13))
                break;
            System.out.println("Помилка, спробуйте ще раз");
        } while (true);

        do {
            System.out.println("\nВведіть день народження " + target);
            day = (getValueFromKeyboardInt(2));
            if ((day > 0) && (day < 31) && (month != 2)) break;
            if ((day == 31) && (monthContains.contains(month))) break;
            if (((day < 29) && (day > 0)) || ((year % 4 == 0) && (day == 29))) break;
            System.out.println("Помилка, спробуйте ще раз");
        } while (true);
        stringBuilder.append(day).append('/').append(month).append('/').append(year);
        return UtilsHuman.parseDateFromStringToLong(String.valueOf(stringBuilder));
    }

    static public int checkIQ(String target) {
        do {
            System.out.println("\nВведіть рівень IQ  max--229 для" + target);
            int iq = (getValueFromKeyboardInt(3));
            if ((iq > 0) && (iq < 230)) return iq;
            System.out.println("Помилка, спробуйте ще раз");
        } while (true);
    }
}