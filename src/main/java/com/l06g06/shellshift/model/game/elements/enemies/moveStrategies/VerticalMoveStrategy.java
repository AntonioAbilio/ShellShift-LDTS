package com.l06g06.shellshift.model.game.elements.enemies.moveStrategies;

import com.l06g06.shellshift.model.game.elements.Position;

public class VerticalMoveStrategy implements MoveStrategy{

    private int distToTop;
    private boolean movingUp;

    public VerticalMoveStrategy(){
        this.distToTop = 0;
        this.movingUp = true;
    }

    @Override
    public Position move(Position currentPos) {
        if (movingUp) {
            distToTop++;
            if (distToTop >= 20){
                movingUp = false;
            }
            return new Position(currentPos.getX(), currentPos.getY() - 1);
        } else {
            distToTop--;
            if (distToTop <= 0){
                movingUp = true;
            }
            return new Position(currentPos.getX(), currentPos.getY() + 1);
        }
    }

}
