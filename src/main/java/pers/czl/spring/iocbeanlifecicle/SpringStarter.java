package pers.czl.spring.iocbeanlifecicle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"pers.czl.spring.iocbeanlifecicle"})
public class SpringStarter {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringStarter.class);
        ((AnnotationConfigApplicationContext) applicationContext).scan("pers.czl.spring");
    }

    @Bean(destroyMethod = "destroy")
    public Tank tank() {
        return new Tank();
    }
}
