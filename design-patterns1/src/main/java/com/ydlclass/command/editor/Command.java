package com.ydlclass.command.editor;

/**
 * @author 
 * @createTime 2023-06-04
 */
public interface Command {

    void execute();

    /**
     * 撤销的功能
     */
    void undo();

}
