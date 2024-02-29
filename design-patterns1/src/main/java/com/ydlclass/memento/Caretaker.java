package com.ydlclass.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @createTime 2023-06-03
 */
public class Caretaker {

    List<Memento> history = new ArrayList<>();

    public void addMemento(Memento memento){
        this.history.add(memento);
    }

    public Memento getMemento(int index){
        return this.history.get(index);
    }

}
