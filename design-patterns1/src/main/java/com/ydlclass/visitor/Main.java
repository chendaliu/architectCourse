package com.ydlclass.visitor;

/**
 * @author
 * @createTime 2023-06-03
 */
public class Main {

    public static void main(String[] args) {

        // 1、构建被访问者对象
        Mouse mouse = new Mouse();
        Keyboard keyboard = new Keyboard();

        Computer computer = new Computer(mouse,keyboard);

        // 2、创建一个访问者
        ComputerVisitor computerVisitor = new ComputerDisplayVisitor();

        // 3、让访问者访问电脑
        computer.accept(computerVisitor);
        mouse.accept(computerVisitor);

        System.out.println("--------------------------");

        computerVisitor = new ComputerUpdateVisitor();
        computer.accept(computerVisitor);

        mouse.accept(computerVisitor);


    }

}
