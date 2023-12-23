package com.l06g06.shellshift.model.game.elements;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class EnemyTest {
    private Position position;

    @BeforeEach
    void setup(){
        Database.getInstance().setSound(true);
        this.position = mock(Position.class);
    }

    @Test
    void getMoveStrategyTest(){
        MoveStrategy moveStrategy = new HorizontalMoveStrategy();
        Enemy enemy = new SoftMonster(position, moveStrategy);
        Assertions.assertEquals(moveStrategy, enemy.getMoveStrategy());
    }

    @Test
    public void hitboxTest(){
        MoveStrategy moveStrategy = mock(MoveStrategy.class);
        SoftMonster softMonster = new SoftMonster(new Position(0, 0), moveStrategy);

        Assertions.assertEquals(1, softMonster.getPolygon().xpoints[0]);
        Assertions.assertEquals(14, softMonster.getPolygon().xpoints[1]);
        Assertions.assertEquals(1, softMonster.getPolygon().xpoints[2]);
        Assertions.assertEquals(14, softMonster.getPolygon().xpoints[3]);

        Assertions.assertEquals(1, softMonster.getPolygon().ypoints[0]);
        Assertions.assertEquals(1, softMonster.getPolygon().ypoints[1]);
        Assertions.assertEquals(14, softMonster.getPolygon().ypoints[2]);
        Assertions.assertEquals(14, softMonster.getPolygon().ypoints[3]);
    }

    @Test
    public void getScoreHPTest(){
        MoveStrategy moveStrategy = mock(MoveStrategy.class);
        SoftMonster softMonster = new SoftMonster(new Position(0, 0), moveStrategy);
        Assertions.assertEquals(50, softMonster.getHP());
        Assertions.assertEquals(20, softMonster.getScore());

        HardMonster hardMonster = new HardMonster(new Position(0, 0), moveStrategy);
        Assertions.assertEquals(100, hardMonster.getHP());
        Assertions.assertEquals(50, hardMonster.getScore());
    }
}
