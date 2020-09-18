package pers.czl.architect.designpattern.flyweight.base;

/**
 * @Title: 享元模式。
 * @Description: 角色：抽象享元类，具体享元类，非共享具体享元类，享元工厂。用于需要创建很多相同或类似的对象的场景，例如数据库连接池
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-17 16:35
 * @Version:1.0
 **/
public class Client {
    public static void main(String[] args) {
        int extrinsic = 22;

        AbstractFlyweight flyweightX = FlyweightFactory.getInstance().getInstance().getFlyweight("X");
        flyweightX.operate(++extrinsic);

        AbstractFlyweight flyweightY = FlyweightFactory.getInstance().getFlyweight("Y");
        flyweightY.operate(++extrinsic);

        AbstractFlyweight flyweightZ = FlyweightFactory.getInstance().getFlyweight("Z");
        flyweightZ.operate(++extrinsic);

        AbstractFlyweight flyweightReX = FlyweightFactory.getInstance().getFlyweight("X");
        flyweightReX.operate(++extrinsic);

        AbstractFlyweight unsharedFlyweight = new UnsharedConcreteFlyweight("X");
        unsharedFlyweight.operate(++extrinsic);
    }
}