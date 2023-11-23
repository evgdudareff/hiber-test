package ioc;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfigWithoutScan.class);

        Fish fish = applicationContext.getBean("getFish", Fish.class);
        fish.say();

        applicationContext.close();
    }
}

