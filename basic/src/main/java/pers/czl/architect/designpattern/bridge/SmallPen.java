package pers.czl.architect.designpattern.bridge;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-16 16:35
 * @Version:1.0
 **/
public class SmallPen extends Pen {

    private Color color;

    @Override
    public void draw(String name) {
        color.bepaint("小号笔", name);
    }
}