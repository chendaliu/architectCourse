package com.ydlclass.decorator;

/**
 * @author
 * @createTime 2023-05-23
 */
public abstract class Decorator implements Component {

    // 装饰器设计模式使用组合的形式进行装设
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }


}
