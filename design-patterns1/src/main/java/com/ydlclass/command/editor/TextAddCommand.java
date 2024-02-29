package com.ydlclass.command.editor;

/**
 * @author 
 * @createTime 2023-06-04
 */
public class TextAddCommand implements Command {

    private StringBuilder sb;
    private String text;


    public TextAddCommand(StringBuilder sb, String text) {
        this.sb = sb;
        this.text = text;
    }

    @Override
    public void execute() {
        sb.append(text);
    }

    @Override
    public void undo() {
        sb.delete(sb.length()-text.length(),sb.length());
    }
}
