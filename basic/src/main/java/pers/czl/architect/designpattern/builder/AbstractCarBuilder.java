package pers.czl.architect.designpattern.builder;

/**
 * 抽象建造者
 */
public abstract class AbstractCarBuilder {
    /**
     * 建造框架
     */
    abstract void buildFrame();

    /**
     * 建造座位
     */
    abstract void buildSeat();

    /**
     * 建造轮胎
     */
    abstract void buildTire();

    abstract Car creatCar();
}
