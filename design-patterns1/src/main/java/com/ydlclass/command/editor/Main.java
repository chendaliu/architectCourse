package com.ydlclass.command.editor;

/**
 * @author
 * @createTime 2023-06-04
 */
public class Main {

    public static void main(String[] args) {

        // 1、创建一个文本编辑器
        TextEditor textEditor = new TextEditor();

        // 3、执行命令
        textEditor.addText("hello ");
        textEditor.addText("world ");
        textEditor.addText("itnanls ");

        textEditor.print();
        textEditor.undo();
        textEditor.print();
        textEditor.undo();
        textEditor.print();


    }

}
