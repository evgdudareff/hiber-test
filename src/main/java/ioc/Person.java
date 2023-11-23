package ioc;

public class Person {
    private Pet pet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Person () {

    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }


//    public Person(Pet pet) {
//        this.pet= pet;
//    }

    public void callPet(){
        pet.say();
    }


}
