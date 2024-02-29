package com.ydlclass.state.mario.state;

/**
 * @author
 * @createTime 2023-06-03
 */
public class MarioFireState implements MarioStatus{

    private Mario mario;

    public MarioFireState(Mario mario) {
        this.mario = mario;
    }

    @Override
    public void eatMushroom() {
        System.out.println("火焰马里奥吃了蘑菇，没变化。");
    }

    @Override
    public void eatFireFlower() {
        System.out.println("火焰马里奥吃了火焰，没变化。");
    }

    @Override
    public void enemyAttack() {
        System.out.println("火焰马里奥遇到敌人，变小。");
        mario.setMarioStatus(new MarioSmallState(mario));
    }

    @Override
    public void fallFit() {
        System.out.println("小马里奥调入坑，死亡。");
        mario.setMarioStatus(new MarioDeadState(mario));
    }
}
