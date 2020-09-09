package pers.czl.architect.designpattern.builder;

/**
 * 丰田汽车建造者
 */
public class FengtianCarBuilder extends AbstractCarBuilder {

    private Car fengtianCar = new Car();

    @Override
    void buildFrame() {
        this.fengtianCar.setFrame("丰田框架");
    }

    @Override
    void buildSeat() {
        this.fengtianCar.setSeat("丰田车座");
    }

    @Override
    void buildTire() {
        this.fengtianCar.setTire("丰田轮胎");
    }

    @Override
    Car creatCar() {
        return fengtianCar;
    }
}