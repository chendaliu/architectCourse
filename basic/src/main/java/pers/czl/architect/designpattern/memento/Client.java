package pers.czl.architect.designpattern.memento;

import pers.czl.architect.designpattern.memento.caretaker.MementoCaretaker;
import pers.czl.architect.designpattern.memento.memento.Memento;
import pers.czl.architect.designpattern.memento.originator.TheGameOfGo;

import java.util.List;

/**
 * 备忘录模式
 * 角色： Originator（原发器）
 * Memento（备忘录)
 * Caretaker（负责人）
 *
 * 模拟场景：围棋可连续悔棋
 *
 * @author: daliu
 * @date: 2022-03-28 16:55
 **/
public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.test();
    }

    private void test() {
        MementoCaretaker caretaker = new MementoCaretaker();
        this.play(caretaker, "白", 20, 20);
        this.play(caretaker, "黑", 19, 19);
        this.play(caretaker, "白", 20, 18);
        this.play(caretaker, "黑", 18, 18);

        this.repentance(caretaker);
        this.repentance(caretaker);
    }

    private void play(MementoCaretaker caretaker, String color, int x, int y) {
        TheGameOfGo t1 = new TheGameOfGo(color, x, y);
        Memento m1 = t1.store(t1);
        caretaker.storeMemento(m1);
    }

    /**
     * 悔棋
     **/
    private void repentance(MementoCaretaker caretaker) {
        System.out.println("---悔棋---");
        Memento memento = caretaker.repentance();
        TheGameOfGo theGameOfGo = new TheGameOfGo();
        theGameOfGo.restore(memento);
    }

}