package com.ydlclass.command;

/**
 * @author 
 * @createTime 2023-06-04
 */
public class LightOnCommand implements Command{

    // 因为你要开的是灯，所以必须持有命令执行的目标对象
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
