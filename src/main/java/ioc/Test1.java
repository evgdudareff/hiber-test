package ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("appConfig1.xml");
        Dog dog1 = applicationContext.getBean("myPet", Dog.class);
        Dog dog2 = applicationContext.getBean("myPet", Dog.class);

        System.out.println(dog1 == dog2);

        applicationContext.close();
    }
}

