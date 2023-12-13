package com.l06g06.shellshift.model.creators;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;

public abstract class MoveStrategyFactory {
    public abstract MoveStrategy createMoveStrategy();
}
