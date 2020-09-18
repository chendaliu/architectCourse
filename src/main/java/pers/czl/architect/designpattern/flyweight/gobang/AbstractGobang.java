package pers.czl.architect.designpattern.flyweight.gobang;

/**
 * @Title: 抽象享元类
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-17 16:29
 * @Version:1.0
 **/
public abstract class AbstractGobang {

    //内部状态:颜色
    private String color;

    protected AbstractGobang(String color) {
        this.color = color;
    }

    public void display(Coordinate extrinsic) {
        System.out.println("棋子颜色：" + this.getColor() + "，棋子位置：" + extrinsic.toString() );
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}