package baseClasses.families;

import baseClasses.humans.Human;
import baseClasses.pets.Pet;

import java.util.List;

public class FamilyController {
    FamilyService serviceFamily= new FamilyService();

    public FamilyService getService() {
        return serviceFamily;
    }

    public void setService(FamilyService service) {
        this.serviceFamily = service;
    }

    public List<Family> getAllFamilies() {
        return serviceFamily.getAllFamilies();
    }
    public void displayAllFamilies(){
        serviceFamily.displayAllFamilies();
    }
    public List<Family> getFamiliesBiggerThan(int count){
       return serviceFamily.getFamiliesBiggerThan(count);
    }

    public List<Family> getFamiliesLessThan(int count){
        return serviceFamily.getFamiliesLessThan(count);
    }
    public int countFamiliesWithMemberNumber(int count){
        return serviceFamily.countFamiliesWithMemberNumber(count);
    }

    public Family createNewFamily(Human mother, Human father){
        return serviceFamily.createNewFamily(mother,father);
    }

    public void deleteFamilyByIndex(int index){
        serviceFamily.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String manName, String womenName){
        return serviceFamily.bornChild(family,manName,womenName);
    }
    public Family adoptChild(Family family, Human human){
        return serviceFamily.adoptChild(family,human);
    }

    public void deleteAllChildrenOlderThen(int age){
        serviceFamily.deleteAllChildrenOlderThen(age);
    }

    public int count(){
        return serviceFamily.getAllFamilies().size();
    }
    public Family getFamilyById(int index){
        return serviceFamily.getFamilyById(index);
    }

    public void addPet(int index, Pet pet){
        serviceFamily.addPet(index,pet);
    }

}
