package pers.czl.architect.designpattern.builder.builder1;

/**
 * 指挥者
 */
public class Director {
    private AbstractCarBuilder abstractCarBuilder;

    public Director(AbstractCarBuilder abstractCarBuilder) {
        this.abstractCarBuilder = abstractCarBuilder;
    }

    public Car construct() {
        abstractCarBuilder.buildFrame();
        abstractCarBuilder.buildSeat();
        abstractCarBuilder.buildTire();

        return abstractCarBuilder.creatCar();
    }
}
