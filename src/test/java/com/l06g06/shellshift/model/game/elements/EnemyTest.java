package com.l06g06.shellshift.model.game.elements;

import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.SimpleTimeZone;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

public class EnemyTest {
    private Position position;

    @BeforeEach
    void setup(){
        this.position = mock(Position.class);
    }

    @Test
    void getMoveStrategyTest(){
        MoveStrategy moveStrategy = new HorizontalMoveStrategy();
        Enemy enemy = new SoftMonster(position, moveStrategy);
        Assertions.assertEquals(moveStrategy, enemy.getMoveStrategy());
    }
}
