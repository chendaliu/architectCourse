package pers.czl.architect.designpattern.memento.memento;

/**
 * @author: daliu
 * @date: 2022-03-28 17:00
 **/
public class Memento {
    private String color;
    private int x;
    private int y;

    public Memento(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setY(int y) {
        this.y = y;
    }
}