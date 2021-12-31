package pers.czl.architect.designpattern.bridge.abstraction;

import pers.czl.architect.designpattern.bridge.implementor.Color;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-16 16:24
 * @Version:1.0
 **/
public abstract class Pen {
    protected Color color;

    public abstract void draw(String name);

    public void setColor(Color color) {
        this.color = color;
    }
}