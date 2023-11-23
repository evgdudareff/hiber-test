package ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigWithoutScan {

    @Bean
    public Pet getFish(){
        return new Fish();

    }
}
