package pers.czl.spring.circulardependencies;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pers.czl.spring.iocbeanlifecicle.Tank;

/*@Configuration
@ComponentScan(basePackages = {"pers.czl.spring.circulardependencies"})*/
public class SpringStarter {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(SpringStarter.class);
    }

}
