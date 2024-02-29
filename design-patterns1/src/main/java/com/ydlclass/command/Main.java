package com.ydlclass.command;

import java.util.List;

/**
 * @author
 * @createTime 2023-06-04
 */
public class Main {

    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        RemoteControl remoteControl = new RemoteControl(lightOnCommand);
        remoteControl.pressButton();

        Command command = new LightOffCommand(light);
        AppControl appControl = new AppControl(command);
        appControl.press();

        List<Command> commands = List.of(
                new LightOffCommand(light),
                new LightOnCommand(light)
        );


        for (Command command1 : commands) {
            appControl.setCommand(command1);
            appControl.press();
        }

        System.out.println("---------------");
        MacroCommand macroCommand = new MacroCommand();
        AirConditioner airConditioner = new AirConditioner();
        AirComditionerOnCommand airComditionerOnCommand = new AirComditionerOnCommand(airConditioner);

        macroCommand.addCommand(airComditionerOnCommand);
        macroCommand.addCommand(lightOnCommand);

        macroCommand.execute();


    }

}
