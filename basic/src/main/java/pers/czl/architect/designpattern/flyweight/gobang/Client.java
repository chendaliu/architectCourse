package pers.czl.architect.designpattern.flyweight.gobang;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-18 13:36
 * @Version:1.0
 **/
public class Client {

    public static void main(String[] args) {
        AbstractGobang gobang1 = GobangFactory.INSTANCE.getGobang(GolangColorEnum.COLOR_BLACK);
        gobang1.display(new Coordinate(10, 10));

        AbstractGobang gobang2 = GobangFactory.INSTANCE.getGobang(GolangColorEnum.COLOR_WHITE);
        gobang2.display(new Coordinate(10, 9));

        AbstractGobang gobang3 = GobangFactory.INSTANCE.getGobang(GolangColorEnum.COLOR_BLACK);
        gobang3.display(new Coordinate(10, 8));

        AbstractGobang gobang4 = GobangFactory.INSTANCE.getGobang(GolangColorEnum.COLOR_WHITE);
        gobang4.display(new Coordinate(8, 9));

    }

}