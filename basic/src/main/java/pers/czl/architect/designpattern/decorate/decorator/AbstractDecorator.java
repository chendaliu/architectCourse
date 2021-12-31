package pers.czl.architect.designpattern.decorate.decorator;

import pers.czl.architect.designpattern.decorate.component.AbstractComponent;

import java.util.Optional;

/**
 * @Title: 抽象装饰者
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-10 20:13
 * @Version:1.0
 **/
public class AbstractDecorator extends AbstractComponent {

    private AbstractComponent component;

    public AbstractDecorator(AbstractComponent component) {
        this.component = component;
    }

    @Override
    public void operation() {
        Optional.ofNullable(component).ifPresent(AbstractComponent::operation);
    }
}