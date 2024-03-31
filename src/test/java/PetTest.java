import baseClasses.enums.Species;
import baseClasses.pets.Dog;
import baseClasses.pets.DomesticCat;
import baseClasses.pets.Fish;
import baseClasses.pets.Pet;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class PetTest {
    @Test
    void toStringTest() {
        Dog pet = new Dog("Rock", 5, 75, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));
        String string = "Dog( nickname='Rock', age=5, trickLevel=75, habits= [eat, drink, sleep], has species: Dog canFly= false, hasFur= true, numberOfLegs= 4)";
        assertEquals(string, pet.toString());
    }

    @Test
    void equalsPositiveTest() {
        Dog pet = new Dog("Rock", 5, 75, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));
        Dog pet1 = new Dog("Rock", 5, 75, new HashSet<> ());
        assertTrue(pet.equals(pet1));

    }

    @Test
    void hashPositiveTest() {
        Dog pet = new Dog("Rock", 5, 75, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));
        Dog pet1 = new Dog("Rock", 5, 75,new HashSet<> ());
        assertEquals(pet1.hashCode(), pet.hashCode());

    }


    @Test
    void hashNegativeTest() {
        Dog pet = new Dog("Bob", 2, 40, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));
        Pet pet1 = new DomesticCat("Bo", 2, 40, new HashSet<> ());
        Pet pet2 = new DomesticCat("Bob", 22, 40, new HashSet<> ());
        Pet expected = new DomesticCat("Bob", 2, 40, new HashSet<> ());
        assertAll("Check Pet HashCode Negative=================================================",
                () -> assertTrue(expected.hashCode() != pet.hashCode()),
                () -> assertTrue(expected.hashCode() != pet1.hashCode()),
                () -> assertTrue(expected.hashCode() != pet2.hashCode()));
    }

    @Test
    void equalsNegativeTest() {
        Dog pet = new Dog("Bob", 2, 40, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));
        Fish pet1 = new Fish("Bo", 2, 40, new HashSet<> ());
        Fish pet2 = new Fish("Bob", 22, 40, new HashSet<> ());
        Fish expected = new Fish("Bob", 2, 40,new HashSet<> ());
        assertAll("Check Pet equals Negative=================================================",
                () -> assertNotEquals(expected, pet),
                () -> assertNotEquals(expected, pet1),
                () -> assertNotEquals(expected, pet2));
    }


}
