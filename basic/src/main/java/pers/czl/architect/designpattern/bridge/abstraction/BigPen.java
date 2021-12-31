package pers.czl.architect.designpattern.bridge.abstraction;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-16 16:25
 * @Version:1.0
 **/
public class BigPen extends Pen {

    @Override
    public void draw(String name) {
        color.bepaint("大号笔", name);
    }

}