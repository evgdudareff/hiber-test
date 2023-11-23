package ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("appConfig2.xml");
        Duck duck = applicationContext.getBean("myDuck", Duck.class);

        duck.say();

        PersonWithAutowiredConstructor personWithAutowiredConstructor =
                applicationContext.getBean("personWithAutowiredConstructor", PersonWithAutowiredConstructor.class);

        PersonWithAutowiredSetter personWithAutowiredSetter =
                applicationContext.getBean("personWithAutowiredSetter", PersonWithAutowiredSetter.class);

        personWithAutowiredConstructor.callPet();
        System.out.println(personWithAutowiredConstructor.getName());

        personWithAutowiredSetter.callPet();

        Bear bear = applicationContext.getBean("myBear", Bear.class);
        bear.say();

        applicationContext.close();
    }
}

