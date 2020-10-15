package pers.czl.architect.designpattern.flyweight.gobang;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-18 13:57
 * @Version:1.0
 **/
public enum GolangColorEnum {
    COLOR_WHITE("white"),

    COLOR_BLACK("black");

    private String color;

    GolangColorEnum(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}