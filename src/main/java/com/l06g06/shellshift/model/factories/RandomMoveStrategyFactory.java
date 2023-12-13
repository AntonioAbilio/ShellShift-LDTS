package com.l06g06.shellshift.model.factories;

import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMoveStrategyFactory {
    private final Random random = new Random();
    private List<MoveStrategyFactory> availableMoveStrategyFactories = new ArrayList<>(0);

    public RandomMoveStrategyFactory() {
        availableMoveStrategyFactories.add(new HorizonalMoveStrategyFactory());
        availableMoveStrategyFactories.add(new VerticalMoveStrategyFactory());
    }
    public MoveStrategy create() {
        return availableMoveStrategyFactories.get(random.nextInt(availableMoveStrategyFactories.size())).createMoveStrategy();
    }


}
