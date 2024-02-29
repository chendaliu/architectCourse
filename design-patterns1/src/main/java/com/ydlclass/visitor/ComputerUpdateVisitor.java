package com.ydlclass.visitor;

/**
 * @author 
 * @createTime 2023-06-03
 */
public class ComputerUpdateVisitor implements ComputerVisitor{

    @Override
    public void visitComputer(Computer computer) {
        System.out.println("电脑被进行了升级");
    }

    @Override
    public void visitMouse(Mouse mouse) {
        System.out.println("鼠标被进行了跟换");
    }

    @Override
    public void visitKeyboard(Keyboard keyboard) {
        System.out.println("键盘被进行了跟换");
    }
}
