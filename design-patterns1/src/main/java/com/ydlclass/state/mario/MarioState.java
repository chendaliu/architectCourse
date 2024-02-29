package com.ydlclass.state.mario;

/**
 * @author 
 * @createTime 2023-06-03
 */
public enum MarioState {
    SMALL(0),BIG(1),FIRE(2),DEAD(3);

    private int index;

    MarioState(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
