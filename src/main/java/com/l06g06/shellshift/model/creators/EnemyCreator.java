package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.VerticalMoveStrategy;

import java.util.Random;

public class EnemyCreator extends Creator {
    @Override
    public Element create(Position position) {
        Random rn_enemy = new Random();
        int i2 = rn_enemy.nextInt(2);

        MoveStrategy moveStrategy;
        Random rn_strategy = new Random();
        int i3 = rn_strategy.nextInt(2);
        if (i3 == 0) moveStrategy = new HorizontalMoveStrategy() ;
        else moveStrategy = new VerticalMoveStrategy();


        if (i2 == 0) return new HardMonster(new Position(position.getX(), position.getY()), moveStrategy);
        return new SoftMonster(new Position(position.getX(), position.getY()), moveStrategy);
    }

}
