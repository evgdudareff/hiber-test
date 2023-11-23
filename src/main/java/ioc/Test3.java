package ioc;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Bear bear = applicationContext.getBean("myBear", Bear.class);
        bear.say();

        PersonWithAutowiredConstructor person = applicationContext.getBean("personWithAutowiredConstructor", PersonWithAutowiredConstructor.class);
        System.out.println(person.getName());

        applicationContext.close();
    }
}

