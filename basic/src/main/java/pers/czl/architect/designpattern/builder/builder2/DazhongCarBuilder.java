package pers.czl.architect.designpattern.builder.builder2;

/**
 * @author: daliu
 * @date: 2021-12-28 15:57
 **/
public class DazhongCarBuilder extends AbstractCarBuilder {

    @Override
    void buildFrame() {
        this.car.setFrame("大众框架");
    }

    @Override
    void buildSeat() {
        this.car.setSeat("大众车座");
    }

    @Override
    void buildTire() {
        this.car.setTire("大众轮胎");
    }
}