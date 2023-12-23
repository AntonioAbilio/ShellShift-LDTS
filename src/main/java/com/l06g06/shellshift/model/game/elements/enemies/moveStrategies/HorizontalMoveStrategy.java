package com.l06g06.shellshift.model.game.elements.enemies.moveStrategies;

import com.l06g06.shellshift.model.game.elements.Position;

public class HorizontalMoveStrategy implements MoveStrategy {
    private int distToLeft;
    private boolean movingLeft;

    public HorizontalMoveStrategy() {
        this.distToLeft = 0;
        this.movingLeft = true;
    }

    @Override
    public Position move(Position currentPos) {
        if (movingLeft) {
            distToLeft++;
            if (distToLeft >= 20) movingLeft = false;
            return new Position(currentPos.getX() - 1, currentPos.getY());
        } else {
            distToLeft--;
            if (distToLeft <= 0) movingLeft = true;
            return new Position(currentPos.getX() + 1, currentPos.getY());
        }
    }

    public int getDistToLeft() {
        return distToLeft;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }
}
