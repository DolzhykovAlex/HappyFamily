package baseClasses;


import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.Woman;
import baseClasses.interfasesOfProgect.HumanCreator;
import baseClasses.pets.Pet;


import java.util.*;

public class Family implements HumanCreator {
    @Override
    public Human bornChild(Family family) {
        Random random = new Random();
        int iq = (family.getFather().getIq() + family.getMother().getIq()) / 2;
        int sex = random.nextInt(101);
        if (sex < 50) {
            String name = NAMES_MAN[random.nextInt(NAMES_MAN.length)];
            return new Man(name, family.getFather().getSurname(), 0, iq);
        } else {
            String name = NAMES_WOMAN[random.nextInt(NAMES_WOMAN.length)];
            return new Woman(name, family.getFather().getSurname(), 0, iq);
        }
    }


    private Human mother;
    private Human father;
    private final ArrayList<Human> children = new ArrayList<>();
    private Set<Pet> pets = new HashSet<>();

    public ArrayList<Human> getChildren() {
        return children;
    }

    public Family(Human mother, Human father, Set<Pet> pets) {
        this.mother = mother;
        this.father = father;
        this.pets = pets;

    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mother= ").append(mother.getName()).append(" ").append(mother.getSurname()).append(", ")
                .append("father= ").append(father.getName()).append(" ").append(father.getSurname());
        if (!children.isEmpty()) {
            for (Human child : children)
                stringBuilder.append(", Child= ").append(child.getName()).append(" ").append(child.getSurname()).append(" Age= ").append(child.getYear());
        } else stringBuilder.append(", NO children");
        if (pets.isEmpty()) stringBuilder.append(", NO PET.");
        else for (Object x : pets)
            stringBuilder.append(new String("\n")).append(x);
        return String.valueOf(stringBuilder);
    }

    public void addChild(Human child) {
        child.setFamily(this);
        children.add(child);
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }


    public void sentChildrenToPrint() {
        System.out.println("This family has " + children.size() + " Children");
        for (Human h : this.children) {
            System.out.println("Name= '" + h.getName()
                    + "' Surname= '" + h.getSurname()
                    + "', age = " + h.getYear()
                    + ", IQ= " + h.getIq());
            System.out.println(h.getClass());
        }
    }


    public boolean deleteChild(int ind) {
        int n = children.size();
        if ((n > ind) && (n != 0)) {
            children.remove(ind);
            return true;
        }
        return false;
    }

    public boolean deleteChild(Human child) {
        return children.remove(child);
    }


    public int countFamily() {
        return children.size() + 2;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public boolean checkPet() {
        if (!pets.isEmpty()) return true;
        else {
            System.out.println("I don`t have PET yet ");
            return false;
        }
    }
}