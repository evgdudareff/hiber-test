package ioc;

import org.springframework.stereotype.Component;

@Component("myDog")
public class Dog implements Pet {
    public void say(){
        System.out.println("bow-wow");

    }
}
