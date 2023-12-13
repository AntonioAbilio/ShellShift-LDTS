package com.l06g06.shellshift.model.factories;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;

public class SoftMonsterFactory extends EnemyFactory {
    @Override
    public Element create(Position position) {
        return new SoftMonster(position, new RandomMoveStrategyFactory().create());
    }
}
