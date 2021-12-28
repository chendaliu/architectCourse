package pers.czl.architect.designpattern.builder.builder1;

/**
 * 丰田汽车建造者
 */
public class FengtianCarBuilder extends AbstractCarBuilder {

    @Override
    void buildFrame() {
        this.car.setFrame("丰田框架");
    }

    @Override
    void buildSeat() {
        this.car.setSeat("丰田车座");
    }

    @Override
    void buildTire() {
        this.car.setTire("丰田轮胎");
    }

}