package pers.czl.architect.designpattern.bradge;

/**
 * @Title:
 * @Description:
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