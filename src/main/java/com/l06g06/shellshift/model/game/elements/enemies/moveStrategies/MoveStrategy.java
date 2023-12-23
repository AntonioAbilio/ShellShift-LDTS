package com.l06g06.shellshift.model.game.elements.enemies.moveStrategies;

import com.l06g06.shellshift.model.game.elements.Position;

public interface MoveStrategy {

    Position move(Position currentPos);
}
