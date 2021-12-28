package pers.czl.architect.designpattern.builder.builder2;


/**
 * 可以将指挥者(Director)和建造者(Builder)合并，进行简化
 * 抽象建造者
 */
public abstract class AbstractCarBuilder {
    Car car = new Car();

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

    public Car creatCar() {
        return car;
    }

    Car build() {
        this.buildFrame();
        this.buildSeat();
        this.buildTire();
        return car;
    }
}
