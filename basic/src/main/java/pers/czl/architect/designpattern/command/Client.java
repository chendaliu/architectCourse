package pers.czl.architect.designpattern.command;

import pers.czl.architect.designpattern.command.command.CloseCommand;
import pers.czl.architect.designpattern.command.command.Command;
import pers.czl.architect.designpattern.command.command.OpenCommand;
import pers.czl.architect.designpattern.command.invoker.Button;

/**
 * 命令模式
 * 角色：
 * 抽象命令类(Command)
 * 具体命令类(ConcreteCommand)，一个具体命令类对应一个请求接收者
 * 命令发送者(Invoker)
 * 命令接收者(Reciever)
 *
 * 作用：解耦命令发送者和命令接收者
 *
 * 思考：如果不使用抽象命令类和具体命令类，使用抽象命令接收类，在命令发送者里依赖抽象命令接收类，感觉也可以，
 * 但是命令接受类不好抽象出来，例如使用第三方命令接受类，就不能抽象出来
 *
 * 测试场景：一个功能按键作为命令发送者，可以给它设置不同的功能
 * @author: daliu
 * @date: 2022-02-17 17:57
 **/
public class Client {

    public static void main(String[] args) {
        Command openCommand = new OpenCommand();
        Command closeCommand = new CloseCommand();

        Button button = new Button();

        button.setCommand(openCommand);
        button.onClick();

        button.setCommand(closeCommand);
        button.onClick();

    }

}