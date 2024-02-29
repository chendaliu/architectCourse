package com.ydlclass.state.tv;

/**
 * 只负责关闭状态的行为
 * @author 
 * @createTime 2023-06-03
 */
public class TVOffState implements TVState{
    @Override
    public void turnOn() {
        System.out.println("正在开启电视");
    }

    @Override
    public void turnOff() {
        System.out.println("电视已经是关闭状态。");
    }

    @Override
    public void adjustVolume(int volume) {
        System.out.println("关闭状态，不能调节音量");
    }
}
