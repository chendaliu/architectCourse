package pers.czl.architect.designpattern.builder.builder2;

/**
 * 建造者模式 <br/>
 * 角色：抽象建造者，具体建造者，产品，指挥者
 */
public class Client {
    public static void main(String[] args) {
        Car dazhongCar = new DazhongCarBuilder().build();
        System.out.println(dazhongCar);
    }
}
