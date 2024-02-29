package com.ydlclass.memento;

/**
 * @author
 * @createTime 2023-06-03
 */
public class Main {

    public static void main(String[] args) {
        // 1、创建发起者，需要建立备忘的对象
        Originator originator = new Originator();

        // 2、建立一个caretaker
        Caretaker caretaker = new Caretaker();

        // 3、修改状态，记录备忘
        originator.setState(12);
        caretaker.addMemento(originator.saveToMemento());


        originator.setState(16);
        caretaker.addMemento(originator.saveToMemento());

        originator.undo(caretaker.getMemento(0));
        System.out.println(originator.getState());

    }

}
