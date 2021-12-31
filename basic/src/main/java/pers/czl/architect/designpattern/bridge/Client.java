package pers.czl.architect.designpattern.bridge;

import pers.czl.architect.designpattern.bridge.abstraction.Pen;
import pers.czl.architect.designpattern.bridge.implementor.Color;

/**
 * 桥接模式
 * 角色：
 * 1.抽象类 Abstraction
 * 2.扩充抽象类 RefinedAbstraction
 *
 * 3.实现类接口 Implementor
 * 4.具体实现类 ConcreteImplementor
 *
 * 适用场景：一个类具有【两个独立变化的维度】。例如带颜色的笔，分两个维度，1笔刷型号大小，2笔颜色。
 * 型号对应抽象部分，颜色对应实现部分。型号和颜色存在一种设置的关系，因此可以在颜色的抽象类中，定义一个设置颜色的方法
 *
 * 参考：https://blog.csdn.net/lovelion/article/details/7464195
 *
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-16 16:52
 * @Version:1.0
 **/
public class Client {

    public static void main(String[] args) {
        XMLUtilPen xmlUtilPen = new XMLUtilPen();
        Color color = (Color) xmlUtilPen.getBean("color");
        Pen pen = (Pen) xmlUtilPen.getBean("pen");

        pen.setColor(color);
        pen.draw("大花猫");
    }

}