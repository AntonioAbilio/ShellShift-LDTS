package com.l06g06.shellshift.model.game.elements.enemies;

import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;

public class SoftMonster extends Enemy {
    public SoftMonster(Position position, MoveStrategy moveStrategy) {
        super(position, 50, moveStrategy);
    }

}
