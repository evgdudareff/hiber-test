package ioc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("myBear")
@Scope("prototype")
public class Bear implements Pet{
    public void say(){
        System.out.println("rrr-rr");

    }

    @PostConstruct
    public void init(){
        System.out.println("Bear was created");

    }

    @PreDestroy
    public void destroy(){
        System.out.println("Bear was created");

    }
}
