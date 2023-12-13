package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import com.l06g06.shellshift.model.game.gun.FireStrategy;

public class HorizonalMoveStrategyFactory extends MoveStrategyFactory{
    @Override
    public MoveStrategy createMoveStrategy() {
        return new HorizontalMoveStrategy();
    }
}
