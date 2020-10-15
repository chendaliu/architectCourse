package pers.czl.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @Title:
 * @Description:
 * @Author: Daliu
 * @CreateTime: 2020-10-13 23:22
 * @Version:1.0
 **/
@Component
public class Dog {

    public void say() {
        System.out.println("小狗说话");
    }

}