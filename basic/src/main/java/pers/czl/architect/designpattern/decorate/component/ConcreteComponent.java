package pers.czl.architect.designpattern.decorate.component;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-10 20:17
 * @Version:1.0
 **/
public class ConcreteComponent extends AbstractComponent {

    @Override
    public void operation() {
        System.out.println("具体操作");
    }
}