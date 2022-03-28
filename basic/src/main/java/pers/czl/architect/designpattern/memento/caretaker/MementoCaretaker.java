package pers.czl.architect.designpattern.memento.caretaker;

import pers.czl.architect.designpattern.memento.memento.Memento;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: daliu
 * @date: 2022-03-28 17:10
 **/
public class MementoCaretaker {

    private LinkedList<Memento> mementoList;

    public MementoCaretaker() {

    }

    public void storeMemento(Memento memento) {
        if (mementoList == null) {
            mementoList = new LinkedList<>();
        }
        mementoList.add(memento);
    }

    /**
     * 悔棋
     **/
    public Memento repentance() {
        return mementoList.pollLast();
    }
}