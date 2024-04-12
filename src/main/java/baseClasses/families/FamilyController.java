package baseClasses.families;

import baseClasses.humans.Human;
import baseClasses.pets.Pet;
import exeptions.FamilyOverflowException;

import java.util.List;

public class FamilyController {
    FamilyService serviceFamily = new FamilyService();

    public FamilyService getService() {
        return serviceFamily;
    }

    public void setService(FamilyService service) {
        this.serviceFamily = service;
    }

    public List<Family> getAllFamilies() {
        return serviceFamily.getAllFamilies();
    }

    public void displayAllFamilies() {
        serviceFamily.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return serviceFamily.getFamiliesBiggerThan(count);
    }

    public List<Family> getFamiliesLessThan(int count) {
        return serviceFamily.getFamiliesLessThan(count);
    }

    public int countFamiliesWithMemberNumber(int count) {
        return serviceFamily.countFamiliesWithMemberNumber(count);
    }

    public Family createNewFamily(Human mother, Human father) {
        return serviceFamily.createNewFamily(mother, father);
    }

    public void deleteFamilyByIndex(int index) {
        serviceFamily.deleteFamilyByIndex(index);
    }

    public void bornChild(Family family, String manName, String womenName) {  //add exception
        try {
             serviceFamily.bornChild(family, manName, womenName);
        } catch (FamilyOverflowException e) {
            System.out.println("Exception  " + e.getMessage());
        }
    }

    public void adoptChild(Family family, Human human) throws FamilyOverflowException {          //add exception
        try {
             serviceFamily.adoptChild(family, human);
        } catch (FamilyOverflowException e) {
            System.out.println("Exception  " + e.getMessage());
        }
    }

    public void deleteAllChildrenOlderThen(int age) {
        serviceFamily.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return serviceFamily.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return serviceFamily.getFamilyById(index);
    }

    public void addPet(int index, Pet pet) {
        serviceFamily.addPet(index, pet);
    }

    public void fillBase() {
        serviceFamily.fillBase();
    }

}
