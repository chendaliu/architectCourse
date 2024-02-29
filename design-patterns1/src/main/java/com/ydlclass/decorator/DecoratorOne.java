package com.ydlclass.decorator;

/**
 * @author
 * @createTime 2023-05-23
 */
public class DecoratorOne extends Decorator{
    public DecoratorOne(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("这是前边添加了行为！--第一次包装");
        super.operation();
        System.out.println("这是后边添加了行为！--第一次包装");
    }
}
