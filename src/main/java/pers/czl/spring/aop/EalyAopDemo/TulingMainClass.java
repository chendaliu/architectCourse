package pers.czl.spring.aop.EalyAopDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.czl.spring.aop.Calculate;

/**
 * Created by xsls on 2019/6/10.
 */
public class TulingMainClass {

    public static void main(String[] args) {

       /* */
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EalyAopMainConfig.class);
        Calculate tulingCalculate = ctx.getBean("tulingCalculate",Calculate.class);
        tulingCalculate.div(1,1);

        /*
        ProxyFactoryBean
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EalyAopMainConfig.class);
        Calculate calculateProxy = ctx.getBean("calculateProxy",Calculate.class);
        System.out.println(calculateProxy.getClass());
        calculateProxy.div(1,1);*/

    }
}
