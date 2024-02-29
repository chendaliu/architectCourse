package com.ydlclass.decorator;

/**
 * @author 
 * @createTime 2023-05-23
 */
public class Main {

    public static void main(String[] args) {
        //1、创建一个原始对象
        Component component = new ConcreteComponent();

        // 2、进行第一次包装
        component = new DecoratorOne(component);

        // 3、进行第二次包装
        component = new DecoratorTwo(component);

        component.operation();

    }

}
