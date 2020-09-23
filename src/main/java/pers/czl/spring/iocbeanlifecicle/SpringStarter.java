package pers.czl.spring.iocbeanlifecicle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"pers.czl.spring.iocbeanlifecicle"})
public class SpringStarter {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(SpringStarter.class);
    }
}
