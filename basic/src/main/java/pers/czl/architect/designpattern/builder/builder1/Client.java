package pers.czl.architect.designpattern.builder.builder1;

/**
 * 建造者模式 <br/>
 * 角色：抽象建造者，具体建造者，产品，指挥者
 */
public class Client {
    public static void main(String[] args) {
        Car dazhongCar = new Director(new DazhongCarBuilder()).construct();
        System.out.println(dazhongCar);

        Car fengtianCar = new Director(new FengtianCarBuilder()).construct();
        System.out.println(fengtianCar);
    }
}
