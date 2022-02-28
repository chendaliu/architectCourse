package pers.czl.architect.designpattern.command.invoker;

import pers.czl.architect.designpattern.command.command.Command;

/**
 * @author: daliu
 * @date: 2022-02-28 10:32
 **/
public class Button {

    private Command command;

    public Button() {

    }

    public void onClick() {
        System.out.println("点击按钮");
        this.command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}