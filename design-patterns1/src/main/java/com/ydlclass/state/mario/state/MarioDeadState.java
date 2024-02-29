package com.ydlclass.state.mario.state;

/**
 * @author 
 * @createTime 2023-06-03
 */
public class MarioDeadState implements MarioStatus{

    private Mario mario;

    public MarioDeadState(Mario mario) {
        this.mario = mario;
    }

    @Override
    public void eatMushroom() {
        System.out.println("马里奥已经死亡");
    }

    @Override
    public void eatFireFlower() {
        System.out.println("马里奥已经死亡");

    }

    @Override
    public void enemyAttack() {
        System.out.println("马里奥已经死亡");
    }

    @Override
    public void fallFit() {
        System.out.println("马里奥已经死亡");
    }
}
