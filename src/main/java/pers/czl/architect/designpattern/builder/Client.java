package pers.czl.architect.designpattern.builder;

public class Client {
    public static void main(String[] args) {
        Car dazhongCar = new Director(new DazhongCarBuilder()).construct();
        System.out.println(dazhongCar);

        Car fengtianCar = new Director(new FengtianCarBuilder()).construct();
        System.out.println(fengtianCar);
    }
}
