package com.ydlclass.command.editor;

import java.util.Stack;

/**
 * @author
 * @createTime 2023-06-04
 */
public class TextEditor {

    // 维护一个核心的文本
    private StringBuilder sb = new StringBuilder();

    private Stack<Command> commands = new Stack<>();


    public void addText(String text){
        // 创建一个新的命令执行，并且保存起来
        TextAddCommand textAddCommand = new TextAddCommand(sb,text);
        textAddCommand.execute();
        commands.push(textAddCommand);
    }
    public void undo(){
        // 找到上一次的命令，并且执行undo方法即可
        Command command = commands.pop();
        command.undo();

    }

    public StringBuilder getSb() {
        return sb;
    }

    public void print(){
        System.out.println(sb);
    }
}
