package com.ydlclass.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 宏命令类,多个基础命令的组合
 * @author
 * @createTime 2023-06-04
 */
public class MacroCommand implements Command{

    // 维护了一组命令
    private List<Command> commands;

    public MacroCommand() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(Command command){
        commands.add(command);
    }


    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
