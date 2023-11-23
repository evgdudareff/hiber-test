package ioc;

import org.springframework.stereotype.Component;

@Component("myDuck")
public class Duck implements Pet{
    public void say(){
        System.out.println("cra-cra");

    }
}
