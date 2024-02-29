package com.ydlclass.decorator;

/**
 * @author
 * @createTime 2023-05-23
 */
public class DecoratorTwo extends Decorator{
    public DecoratorTwo(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("这是前边添加了行为！--第二次包装");
        super.operation();
        System.out.println("这是后边添加了行为！--第二次包装");
    }
}
