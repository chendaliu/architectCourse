package pers.czl.architect.designpattern.command.command;

import pers.czl.architect.designpattern.command.reviever.CloseHandle;

/**
 * @author: daliu
 * @date: 2022-02-28 10:28
 **/
public class CloseCommand implements Command {

    private CloseHandle closeHandle;

    public CloseCommand() {
        this.closeHandle = new CloseHandle();
    }

    @Override
    public void execute() {
        this.closeHandle.close();
    }

}