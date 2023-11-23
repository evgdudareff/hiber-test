package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personWithAutowiredConstructor")
public class PersonWithAutowiredConstructor {
    private Pet pet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Value("${person.name}")
    private String name;

    @Autowired
    public PersonWithAutowiredConstructor(@Qualifier("myDog") Pet pet) {
        this.pet= pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }


    public void callPet(){
        pet.say();
    }


}
