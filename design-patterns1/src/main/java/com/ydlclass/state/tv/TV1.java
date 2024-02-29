package com.ydlclass.state.tv;

/**
 * @author
 * @createTime 2023-06-03
 */
public class TV1 {

    // 1、应该持有状态
    TVState tvState;

    public TV1() {
        this.tvState = new TVOffState();
    }

    /**
     * 用来改变电视机的状态
     * @param tvState 新的状态
     */
    public void setTvState(TVState tvState) {
        this.tvState = tvState;
    }

    public void turnOn() {
        // 由具体的状态实现来完成开机动作
        tvState.turnOn();
        // 开机之后，需要将状态改为开机
        setTvState(new TVOnState());
    }

    public void turnOff() {
        tvState.turnOff();
        setTvState(new TVOffState());
    }

    public void adjustVolume(int volume) {
        tvState.adjustVolume(volume);
    }


}
