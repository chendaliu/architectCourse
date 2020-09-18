package pers.czl.architect.designpattern.decorate;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-10 20:21
 * @Version:1.0
 **/
public class ConcreteDecoratorB extends AbstractDecorator {

    public ConcreteDecoratorB(AbstractComponent component) {
        super(component);
    }

    private void method() {
        System.out.println("B的修饰");
    }

    @Override
    public void operation() {
        super.operation();
        this.method();
    }
}