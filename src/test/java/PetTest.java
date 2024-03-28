import baseClasses.enums.Species;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PetTest {
//    @Test
//    void toStringTest() {
//        Pet pet = new Pet(Species.Species.DOG, "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
//        String string = "Dog(nickname='Rock', age=5, trickLevel=75, habits= [eat, drink, sleep]," +
//                " has species: canFly= false, hasFur= true, numberOfLegs= 4)";
//        assertEquals(string, pet.toString());
//    }
//    @Test
//    void equalsPositiveTest() {
//        Pet pet = new Pet(Species.Species.DOG, "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
//        Pet pet1 = new Pet(Species.Species.DOG, "Rock", 5, 75, new String[]{});
//        assertTrue(pet.equals(pet1));
//
//    }
//
//    @Test
//    void hashPositiveTest() {
//        Pet pet = new Pet(Species.Species.DOG, "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
//        Pet pet1 = new Pet(Species.Species.DOG, "Rock", 5, 75, new String[]{});
//        assertEquals(pet1.hashCode(), pet.hashCode());
//
//    }
//
//
//    @Test
//    void hashNegativeTest() {
//        Pet pet = new Pet(Species.Species.DOG, "Bob", 2, 40, new String[]{"eat", "drink", "sleep"});
//        Pet pet1 = new Pet(Species.Species.CAT, "Bo", 2, 40, new String[]{});
//        Pet pet2 = new Pet(Species.Species.CAT, "Bob", 22, 40, new String[]{});
//        Pet expected = new Pet(Species.Species.CAT, "Bob", 2, 40, new String[]{});
//        assertAll("Check Pet HashCode Negative=================================================",
//                () -> assertTrue(expected.hashCode() != pet.hashCode()),
//                () -> assertTrue(expected.hashCode() != pet1.hashCode()),
//                () -> assertTrue(expected.hashCode() != pet2.hashCode()));
//    }
//
//    @Test
//    void equalsNegativeTest() {
//        Pet pet = new Pet(Species.Species.DOG, "Bob", 2, 40, new String[]{"eat", "drink", "sleep"});
//        Pet pet1 = new Pet(Species.Species.CAT, "Bo", 2, 40, new String[]{});
//        Pet pet2 = new Pet(Species.Species.CAT, "Bob", 22, 40, new String[]{});
//        Pet expected = new Pet(Species.Species.CAT, "Bob", 2, 40, new String[]{});
//        assertAll("Check Pet equals Negative=================================================",
//                () -> assertNotEquals(expected, pet),
//                () -> assertNotEquals(expected, pet1),
//                () -> assertNotEquals(expected, pet2));
//    }





}
