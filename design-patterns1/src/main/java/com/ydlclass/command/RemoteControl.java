package com.ydlclass.command;

/**
 * @author
 * @createTime 2023-06-04
 */
public class RemoteControl {

    private Command command;

    public RemoteControl(Command command) {
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }

}
