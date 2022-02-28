package pers.czl.architect.designpattern.command.command;

import pers.czl.architect.designpattern.command.reviever.OpenHandle;

/**
 * @author: daliu
 * @date: 2022-02-28 10:26
 **/
public class OpenCommand implements Command {

    private OpenHandle openHandle;

    public OpenCommand() {
        this.openHandle = new OpenHandle();
    }

    @Override
    public void execute() {
        this.openHandle.open();
    }

}