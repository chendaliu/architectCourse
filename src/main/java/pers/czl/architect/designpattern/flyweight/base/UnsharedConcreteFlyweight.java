package pers.czl.architect.designpattern.flyweight.base;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-17 16:34
 * @Version:1.0
 **/
public class UnsharedConcreteFlyweight extends AbstractFlyweight {

    protected UnsharedConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    @Override
    public void operate(int extrinsic) {
        System.out.println("不共享的具体Flyweight:" + extrinsic);
    }
}