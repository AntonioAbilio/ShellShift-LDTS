package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;

public class HardMonsterFactory extends EnemyFactory{
    @Override
    public Element create(Position position) {
        return new HardMonster(position, new RandomMoveStrategyFactory().create());
    }
}
