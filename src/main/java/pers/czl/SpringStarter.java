package pers.czl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStarter {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(SpringStarter.class);
    }
}
