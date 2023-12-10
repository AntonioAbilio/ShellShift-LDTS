package com.l06g06.shellshift.controller;

import com.l06g06.shellshift.controller.game.elements.enemies.EnemyController;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import com.l06g06.shellshift.model.game.map.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class EnemyControllerTest {
    private Map mockedMap ;
    private Enemy mockedEnemy;
    private List<Enemy> enemies;
    private MoveStrategy mockedMoveStrategy;
    private EnemyController enemyController;
    private int distBetweenEnemy;


    @BeforeEach
    public void setup(){
        this.mockedMap = mock(Map.class);
        this.mockedEnemy = mock(Enemy.class);
        this.enemies = new ArrayList<>();
        this.mockedMoveStrategy = mock(MoveStrategy.class);
        this.distBetweenEnemy = 15;
        Mockito.when(mockedMap.getEnemies()).thenReturn(enemies);
        this.enemyController = new EnemyController(mockedMap);
    }

    @Test
    public void leftShiftTest(){
        Position position = new Position(0, 0);
        Enemy enemy = new SoftMonster(position, mockedMoveStrategy);
        enemies.add(enemy);

        // Make sure Enemy starts with correct Position
        Assertions.assertEquals(position, enemy.getPosition());

        // Check if Enemy is left shifting correctly
        enemyController.left_shift();
        Position expectedPos = new Position(-1, 0);
        Assertions.assertEquals(expectedPos, enemy.getPosition());
    }

    @Test
    public void enemyInPosTest() {
        Enemy enemy1 = new SoftMonster(new Position(1,  0), mockedMoveStrategy);
        Enemy enemy2 = new HardMonster(new Position(16, 5), mockedMoveStrategy);
        Enemy enemy3 = new HardMonster(new Position(32, 9), mockedMoveStrategy);
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);

        // Position is too close to an Enemy
        Position position1 = new Position( 5, 5);
        Assertions.assertFalse(enemyController.noEnemyInPos(position1));
        Position position2 = new Position( 46, 5);
        Assertions.assertFalse(enemyController.noEnemyInPos(position2));

        // Position is far enough from an Enemy
        Position position3 = new Position( 100, 5);
        Assertions.assertTrue(enemyController.noEnemyInPos(position3));
        Position position4 = new Position( 47, 5);
        Assertions.assertTrue(enemyController.noEnemyInPos(position4));
    }

    @Test
    public void spawnOnPlatformTest(){
        // ToDo
    }

}
