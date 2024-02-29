package com.ydlclass.visitor;

/**
 * 访问者接口
 * @author 
 * @createTime 2023-06-03
 */
public interface ComputerVisitor {

    // 他可能会访问一些组件
    void visitComputer(Computer computer);

    void visitMouse(Mouse mouse);

    void visitKeyboard(Keyboard keyboard);

}
