package factory;

import factory.beans.Contract;
import factory.beans.Passport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {

    // Создаем бины
    @Bean(name = "Contract")
    @Scope("prototype")
    public Contract Contract() {
        return new Contract();
    }

    @Bean(name = "Passport")
    @Scope("prototype")
    public Passport Passport() {
        return new Passport();
    }
}