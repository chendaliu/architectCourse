package com.ydlclass.command;

/**
 * @author 
 * @createTime 2023-06-04
 */
public class AirComditionerOffCommand implements Command{

    // 因为你要开的是灯，所以必须持有命令执行的目标对象
    private AirConditioner airConditioner;

    public AirComditionerOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOff();
    }
}
