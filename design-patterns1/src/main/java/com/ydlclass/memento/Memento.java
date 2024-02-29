package com.ydlclass.memento;

/**
 * @author
 * @createTime 2023-06-03
 */
public class Memento {

    private int state;

    public Memento(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
