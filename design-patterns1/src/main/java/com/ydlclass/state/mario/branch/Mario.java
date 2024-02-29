package com.ydlclass.state.mario.branch;

import com.ydlclass.state.mario.Event;
import com.ydlclass.state.mario.MarioState;

/**
 * @author 
 * @createTime 2023-06-03
 */
public class Mario {

    MarioState marioState;

    public Mario() {
        this.marioState = MarioState.SMALL;
    }

    public void handleEvent(Event event){
        if(marioState == MarioState.DEAD){
            return;
        }
        // 不同状态下吃蘑菇会有什么反应
        if(event == Event.MUSHROOM){
            // 只有小马里奥吃蘑菇，才会变大
            if(marioState == MarioState.SMALL){
                marioState = MarioState.BIG;
            }
        } else if (event == Event.FIRE_FLOWER) {
            // 只有大马里奥吃火花才行
            if(marioState == MarioState.BIG){
                marioState = MarioState.FIRE;
            }
        } else if (event == Event.ENEMY_ATTACK) {
            if(marioState ==MarioState.SMALL){
                marioState = MarioState.DEAD;
            } else if (marioState == MarioState.BIG || marioState == MarioState.FIRE) {
                marioState = MarioState.SMALL;
            }
        } else if (event == Event.FALL_INTO_PIT) {
            marioState = MarioState.DEAD;
        }
    }

    public static void main(String[] args) {
        Mario mario = new Mario();

        mario.handleEvent(Event.MUSHROOM);
        mario.handleEvent(Event.FIRE_FLOWER);
//        mario.handleEvent(Event.ENEMY_ATTACK);

        System.out.println(mario.marioState);

    }

}
