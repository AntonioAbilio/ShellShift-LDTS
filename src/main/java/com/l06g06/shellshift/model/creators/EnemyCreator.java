package com.l06g06.shellshift.model.creators;

import com.google.common.annotations.VisibleForTesting;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.VerticalMoveStrategy;

import java.util.Random;

public class EnemyCreator extends Creator {

    private Random rn = new Random();
    @VisibleForTesting
    public void setRandomSeed(long seed){
        rn = new Random(seed);
    }

    @Override
    public Element create(Position position) {
        MoveStrategy moveStrategy;

        int i = rn.nextInt(2);
        if (i == 0) moveStrategy = new HorizontalMoveStrategy();
        else moveStrategy = new VerticalMoveStrategy();

        int i2 = rn.nextInt(2);
        if (i2 == 0) return new HardMonster(position, moveStrategy);
        else return new SoftMonster(position, moveStrategy);
    }
}
