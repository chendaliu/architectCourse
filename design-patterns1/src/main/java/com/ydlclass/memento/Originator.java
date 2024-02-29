package com.ydlclass.memento;

/**
 * @author
 * @createTime 2023-06-03
 */
public class Originator {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    // 保存到备忘录
    public Memento saveToMemento(){
        return new Memento(state);
    }

    // 回复到某一个历史记录
    public void undo(Memento memento){
        this.state = memento.getState();
    }

}
