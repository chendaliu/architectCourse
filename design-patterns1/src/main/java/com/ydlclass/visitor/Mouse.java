package com.ydlclass.visitor;

/**
 * @author 
 * @createTime 2023-06-03
 */
public class Mouse implements ComputerPart{
    @Override
    public void accept(ComputerVisitor computerVisitor) {
        computerVisitor.visitMouse(this);
    }
}
