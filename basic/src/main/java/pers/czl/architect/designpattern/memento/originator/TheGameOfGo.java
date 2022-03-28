package pers.czl.architect.designpattern.memento.originator;

import pers.czl.architect.designpattern.memento.memento.Memento;

/**
 * 围棋
 *
 * @author: daliu
 * @date: 2022-03-28 16:59
 **/
public class TheGameOfGo {

    private String color;
    private int x;
    private int y;

    public TheGameOfGo() {
    }

    public TheGameOfGo(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        System.out.println(this.getColor() + ":" + this.getX() + "," + this.getY());
    }

    public Memento store(TheGameOfGo theGameOfGo) {
        return new Memento(theGameOfGo.getColor(), theGameOfGo.getX(), theGameOfGo.getY());
    }

    public void restore(Memento memento) {
        this.setColor(memento.getColor());
        this.setX(memento.getX());
        this.setY(memento.getY());
        System.out.println(this.getColor() + ":" + this.getX() + "," + this.getY());
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public void setY(int y) {
        this.y = y;
    }
}