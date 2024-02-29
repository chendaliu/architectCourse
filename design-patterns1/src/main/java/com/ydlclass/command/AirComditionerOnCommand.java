package com.ydlclass.command;

/**
 * @author
 * @createTime 2023-06-04
 */
public class AirComditionerOnCommand implements Command{

    // 因为你要开的是灯，所以必须持有命令执行的目标对象
    private AirConditioner airConditioner;

    public AirComditionerOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOn();

    }
}
