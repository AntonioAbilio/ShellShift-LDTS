package com.l06g06.shellshift.model.game.elements.enemies.moveStrategies;

import com.l06g06.shellshift.model.game.elements.Position;

public class VerticalMoveStrategy implements MoveStrategy{
    @Override
    public Position move(Position currentPos) {
        return currentPos;
    }
}
