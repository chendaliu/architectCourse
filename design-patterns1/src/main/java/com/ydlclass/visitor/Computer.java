package com.ydlclass.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 * @createTime 2023-06-03
 */
public class Computer implements ComputerPart{

    // 组合构建
    private List<ComputerPart> computerParts;

    public Computer(Mouse mouse,Keyboard keyboard) {
        computerParts = new ArrayList<>();
        computerParts.add(mouse);
        computerParts.add(keyboard);
    }

    @Override
    public void accept(ComputerVisitor computerVisitor) {
        // 对于电脑而言，访问者需要访问他的每一个构建
        for (ComputerPart computerPart : computerParts) {
            computerPart.accept(computerVisitor);
        }
    }
}
