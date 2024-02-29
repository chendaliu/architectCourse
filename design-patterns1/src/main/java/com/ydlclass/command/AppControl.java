package com.ydlclass.command;

/**
 * @author
 * @createTime 2023-06-04
 */
public class AppControl {

    private Command command;

    public AppControl(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void press(){
        command.execute();
    }

}
