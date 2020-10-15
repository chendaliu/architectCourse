package pers.czl.architect.designpattern.decorate;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-10 20:18
 * @Version:1.0
 **/
public class ConcreteDecoratorA extends AbstractDecorator {

    public ConcreteDecoratorA(AbstractComponent component) {
        super(component);
    }

    private void method() {
        System.out.println("A的修饰");
    }

    @Override
    public void operation() {
        this.method();
        super.operation();
    }
}