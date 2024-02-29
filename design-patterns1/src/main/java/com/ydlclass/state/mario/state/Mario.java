package com.ydlclass.state.mario.state;

import com.ydlclass.state.mario.Event;
import lombok.Data;

/**
 * @author
 * @createTime 2023-06-03
 */
@Data
public class Mario {

    private MarioStatus marioStatus;

    public Mario() {
        this.marioStatus = new MarioSmallState(this);
    }

    public void handEvent(Event event){
        if(event == Event.MUSHROOM){
            marioStatus.eatMushroom();
        } else if(event == Event.FIRE_FLOWER){
            marioStatus.eatFireFlower();
        } else if(event == Event.ENEMY_ATTACK){
            marioStatus.enemyAttack();
        } else if (event == Event.FALL_INTO_PIT){
            marioStatus.fallFit();
        }
    }

    public static void main(String[] args) {
        Mario mario = new Mario();

        mario.handEvent(Event.MUSHROOM);
        mario.handEvent(Event.FIRE_FLOWER);
        mario.handEvent(Event.ENEMY_ATTACK);
        mario.handEvent(Event.FALL_INTO_PIT);
    }

}
