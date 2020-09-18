package pers.czl.architect.designpattern.flyweight.base;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-17 16:33
 * @Version:1.0
 **/
public class ConcreteFlyweight extends AbstractFlyweight {

    //接受外部状态
    protected ConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    @Override
    public void operate(int extrinsic) {
        System.out.println("具体Flyweight:" + extrinsic);
    }
}