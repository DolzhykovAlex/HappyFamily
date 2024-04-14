package baseClasses.families;


import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.Woman;
import baseClasses.interfasesOfProgect.HumanCreator;
import baseClasses.pets.Pet;


import java.io.Serializable;
import java.util.*;

public class Family implements HumanCreator , Serializable {


    private Human mother;
    private Human father;
    private final ArrayList<Human> children = new ArrayList<>();
    private Set<Pet> pets = new HashSet<>();

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

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
    public Human bornChild(Family family) {
        Random random = new Random();
        int iq = (family.getFather().getIq() + family.getMother().getIq()) / 2;
        int sex = random.nextInt(101);
        if (sex < 50) {
            String name = NAMES_MAN[random.nextInt(NAMES_MAN.length)];
            return new Man(name, family.getFather().getSurname(), System.currentTimeMillis() / 1000, iq);
        } else {
            String name = NAMES_WOMAN[random.nextInt(NAMES_WOMAN.length)];
            return new Woman(name, family.getFather().getSurname(), System.currentTimeMillis() / 1000, iq);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }


    @Override
    public String toString() {
        return prettyFormat();
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
                    + "', age = " + h.getBirthDate()
                    + ", IQ= " + h.getIq());
            System.out.println(h.getClass());
        }
    }


    public boolean deleteChild(int ind) {
        int n = children.size();
        if ((n > ind) && (n != 0) && (ind >= 0)) {
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

    public String prettyFormat() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n Family:" + "\n      father: ").append(father.prettyFormat()).append("\n      mother: ").append(mother.prettyFormat()).append("\n  children: \n");
        if (children.isEmpty()) stringBuilder.append("          no children yet \n");
        else
            getChildren().forEach(human -> stringBuilder.append("          ").append(prettyChildren(human)));
        stringBuilder.append("     pets:\n");
        if (pets.isEmpty()) stringBuilder.append("          NO PET.");
        else getPets().forEach(pet -> stringBuilder.append("          ").append(pet.prettyFormat()).append("\n"));
        return String.valueOf(stringBuilder);
    }

    public String prettyChildren(Human human) {
        StringBuilder stringBuilder = new StringBuilder();
        if (human.getClass().equals(Man.class))
            stringBuilder.append("Boy: ");
        else stringBuilder.append("Girl: ");
        stringBuilder.append(human.prettyFormat()).append("\n");
        return String.valueOf(stringBuilder);
    }

}