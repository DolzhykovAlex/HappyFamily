package baseClasses;


import baseClasses.humans.Human;
import baseClasses.humans.Man;
import baseClasses.humans.Woman;
import baseClasses.pets.Pet;


import java.util.Objects;

public class Family {


    private Human mother;
    private Human father;
    private Human[] children;
    Pet pet;


    public Family(Human mother, Human father, Pet pet) {
        this.mother = mother;
        this.father = father;
        this.pet = pet;
        this.children = new Human[0];
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
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
        if (children.length != 0) {
            for (Human child : children)
                stringBuilder.append(", Child= ").append(child.getName()).append(" ").append(child.getSurname());
        } else stringBuilder.append(", NO children");
        if (null == pet) stringBuilder.append(", NO PET.");
        else stringBuilder.append(", pet = ").append(pet);
        return String.valueOf(stringBuilder);
    }

    public void addChild(Human child) {
        child.setFamily(this);
        int i = this.children.length;
        Human[] newChild = new Human[i + 1];
        if (i != 0) System.arraycopy(child.getFamily().getChildren(), 0, newChild, 0, i);
        //  newChild= Arrays.copyOf((child.getFamily().getChildren()),i+1);
        newChild[i] = child;
        this.children = newChild;
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

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }



    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public boolean deleteChild(int ind) {
        int n = children.length;
        if ((n > ind) && (n != 0)) {
            int mark = 0;
            Human[] newChildren = new Human[n - 1];
            for (int i = 0; i < n; i++) {
                if (i != ind) newChildren[i - mark] = children[i];
                else mark++;
            }
            this.children = newChildren;
            return true;
        }
        return false;
    }

    public boolean deleteChild(Man child) {
        int n = children.length;
        if (n != 0) {
            int mark = 0;
            Human[] newChildren = new Human[n - 1];
            for (int i = 0; i < n; i++) {
                if (!children[i].equals(child)) {
                    if ((mark != 0) || (i != n - 1)) newChildren[i - mark] = children[i];
                } else mark++;
            }
            if (mark == 1) {
                this.children = newChildren;
                return true;
            }
        }
        return false;
    }

    public boolean deleteChild(Woman child) {
        int n = children.length;
        if (n != 0) {
            int mark = 0;
            Human[] newChildren = new Human[n - 1];
            for (int i = 0; i < n; i++) {
                if (!children[i].equals(child)) {
                    if ((mark != 0) || (i != n - 1)) newChildren[i - mark] = children[i];
                } else mark++;
            }
            if (mark == 1) {
                this.children = newChildren;
                return true;
            }
        }
        return false;
    }


    public int countFamily() {
        return children.length + 2;
    }

}
