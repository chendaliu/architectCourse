package pers.czl.architect.designpattern.builder;

/**
 * 大众汽车建造者
 */
public class DazhongCarBuilder extends AbstractCarBuilder {

    private Car dazhongCar = new Car();

    @Override
    void buildFrame() {
        this.dazhongCar.setFrame("大众框架");
    }

    @Override
    void buildSeat() {
        this.dazhongCar.setSeat("大众车座");
    }

    @Override
    void buildTire() {
        this.dazhongCar.setTire("大众轮胎");
    }

    @Override
    Car creatCar() {
        return dazhongCar;
    }
}
