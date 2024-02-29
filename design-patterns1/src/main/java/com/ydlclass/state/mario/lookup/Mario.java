package com.ydlclass.state.mario.lookup;

import com.ydlclass.state.mario.Event;
import com.ydlclass.state.mario.MarioState;

/**
 * @author
 * @createTime 2023-06-03
 */
public class Mario {

    MarioState marioState;

    // 使用二维数组定义状态转换表
    private static final MarioState[][] TRANSITION_TABLE = {
            // SMALL, BIG, FIRE, DEAD
            {MarioState.BIG, MarioState.BIG, MarioState.FIRE, MarioState.DEAD}, // MUSHROOM
            {MarioState.SMALL, MarioState.FIRE, MarioState.FIRE, MarioState.DEAD}, // FIRE_FLOWER
            {MarioState.DEAD, MarioState.SMALL, MarioState.SMALL, MarioState.DEAD}, // ENEMY_ATTACK
            {MarioState.DEAD, MarioState.DEAD, MarioState.DEAD, MarioState.DEAD}  // FALL_INTO_PIT
    };

    public Mario() {
        this.marioState = MarioState.SMALL;
    }

    public void handleEvent(Event event){
        if(marioState == MarioState.DEAD){
            return;
        }
        // 通过根据状态和行为查表，得到转移后的状态
        marioState = TRANSITION_TABLE[event.getIndex()][marioState.getIndex()];
    }

    public static void main(String[] args) {
        Mario mario = new Mario();

        mario.handleEvent(Event.MUSHROOM);
        mario.handleEvent(Event.FIRE_FLOWER);
        mario.handleEvent(Event.ENEMY_ATTACK);
        mario.handleEvent(Event.FALL_INTO_PIT);

        System.out.println(mario.marioState);

    }

}
