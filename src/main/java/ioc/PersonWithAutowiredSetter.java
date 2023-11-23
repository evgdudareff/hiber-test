package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("personWithAutowiredSetter")
public class PersonWithAutowiredSetter {
    private Pet pet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Autowired
    @Qualifier("myDuck")
    public void setPet(Pet pet) {
        this.pet = pet;
    }


    public void callPet(){
        pet.say();
    }


}
