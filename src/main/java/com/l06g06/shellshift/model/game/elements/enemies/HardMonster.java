package com.l06g06.shellshift.model.game.elements.enemies;

import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;

public class HardMonster extends Enemy {

    public HardMonster(Position position, MoveStrategy moveStrategy) {
        super(position, 100, moveStrategy);
    }

}
