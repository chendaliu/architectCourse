package pers.czl.architect.designpattern.bradge;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-16 16:34
 * @Version:1.0
 **/
public class MiddlePen extends Pen {

    private Color color;

    @Override
    public void draw(String name) {
        color.bepaint("中号笔", name);
    }
}