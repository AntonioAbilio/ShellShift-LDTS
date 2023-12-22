package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.CoinController;
import com.l06g06.shellshift.controller.game.elements.PlatformController;
import com.l06g06.shellshift.controller.game.elements.enemies.EnemyController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import com.l06g06.shellshift.model.game.map.EnemySpawnerTest;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.game.spawners.EnemySpawner;
import com.l06g06.shellshift.model.game.spawners.PlatformSpawner;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class EnemyControllerTest {
    private Map mockedMap ;
    private Enemy mockedEnemy;
    private List<Enemy> enemies;
    private MoveStrategy mockedMoveStrategy;
    private EnemyController enemyController;
    private int distBetweenEnemy;


    @BeforeEach
    void setup(){
        this.mockedMap = mock(Map.class);
        this.mockedEnemy = mock(Enemy.class);
        this.enemies = new ArrayList<>();
        this.mockedMoveStrategy = mock(MoveStrategy.class);
        this.distBetweenEnemy = 15;
        Mockito.when(mockedMap.getEnemies()).thenReturn(enemies);
        this.enemyController = new EnemyController(mockedMap);
    }

    @Test
    void stepCallTest(){
        Game game = mock(Game.class);
        List<Gui.PressedKey> action = new ArrayList<>();
        Position chellPosition = new Position(3, 1);
        Chell chell = new Chell(chellPosition);
        Mockito.when(mockedMap.getChell()).thenReturn(chell);
        EnemyController spyEnemyController = Mockito.spy(enemyController);

        long time = 6000; // 6 seconds
        enemyController.setLastSpawnTime(0);
        Mockito.when(mockedMap.getSpawnCooldown()).thenReturn(2);
        enemyController.setLastShiftTime(0);

        spyEnemyController.step(game, action, time);
        Mockito.verify(spyEnemyController, Mockito.times(1)).spawnOnPlatform();
        Mockito.verify(spyEnemyController, Mockito.times(1)).left_shift();
    }

    @Test
    void stepConditionTest(){
        Game game = mock(Game.class);
        List<Gui.PressedKey> action = new ArrayList<>();
        Position chellPosition = new Position(3, 1);
        Chell chell = new Chell(chellPosition);
        Mockito.when(mockedMap.getChell()).thenReturn(chell);

        long time = 6000; // 6 seconds
        enemyController.setLastSpawnTime(0);
        Mockito.when(mockedMap.getSpawnCooldown()).thenReturn(2);
        enemyController.setLastShiftTime(0);

        enemyController.step(game, action, time);
        Assertions.assertEquals(time / 1000, enemyController.getLastSpawnTime());
        Assertions.assertEquals(time / 1000, enemyController.getLastShiftTime());
    }

    @Test
     void leftShiftTest(){
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
    void enemyInPosTest() {
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

        // Negative distance
        Position position5 = new Position( 15, 5);
        Assertions.assertFalse(enemyController.noEnemyInPos(position5));
    }

    @Test
    void spawnOnPlatformTest(){
        enemies = new ArrayList<>();
        List<Platform> platforms = new ArrayList<>();
        Platform platform1 = new Platform(new Position(100,  0));
        Platform platform2 = new Platform(new Position(5, 5));
        Platform platform3 = new Platform(new Position(230, 9));
        platforms.add(platform1);
        platforms.add(platform2);
        platforms.add(platform3);
        when(mockedMap.getPlatforms()).thenReturn(platforms);
        EnemySpawner enemySpawner = mock(EnemySpawner.class);
        when(mockedMap.getEnemySpawner()).thenReturn(enemySpawner);

        enemyController.spawnOnPlatform();

        verify(mockedMap.getEnemySpawner(), times(1)).spawn(any(Position.class));
    }

    @Test
    void enemyChellCollisionTest(){
        Chell chell = new Chell(new Position(3, 1));
        when(mockedMap.getChell()).thenReturn(chell);
        Enemy enemy1 = new SoftMonster(new Position(1,  0), mockedMoveStrategy);
        Enemy enemy2 = new HardMonster(new Position(16, 5), mockedMoveStrategy);
        Enemy enemy3 = new HardMonster(new Position(32, 9), mockedMoveStrategy);
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);

        Assertions.assertEquals(3, mockedMap.getEnemies().size());
        enemyController.enemyChellCollision();
        Assertions.assertEquals(2, mockedMap.getEnemies().size());


        // ToDo: remove
        /*int test_x_inf = -20;
        int test_x_sup = 20;
        int test_y_inf = -30;
        int test_y_sup = 30;

        System.out.println("Enemy 1 has x: " + enemyController.getModel().getEnemies().get(0).getPosition().getX() + " y: " + enemyController.getModel().getEnemies().get(0).getPosition().getY());
        for (int i = test_x_inf; i <= test_x_sup; i++) {
            for (int j = test_y_inf; j <= test_y_sup; j++) {
                // Update Chell's position
                enemyController.getModel().getChell().setPosition(new Position(i, j));

                // Check for intersection
                if (enemyController.getModel().getChell().getPolygon().intersects(enemyController.getModel().getEnemies().get(0).getPolygon().getBounds2D())) {
                    System.out.println("Intersection found at Chell x: " + i + " y: " + j);
                }
            }
        }*/
    }

    @Test
    void stepSpawnConditionTest(){
        Game game = mock(Game.class);
        List<Gui.PressedKey> action = new ArrayList<>();
        Map map = mock(Map.class);
        enemyController = new EnemyController(map);
        Chell chell = new Chell(new Position(3, 1));
        when(map.getChell()).thenReturn(chell);
        List<Platform> platforms = new ArrayList<>();
        when(map.getPlatforms()).thenReturn(platforms);

        EnemySpawner enemySpawner = mock(EnemySpawner.class);
        when(map.getEnemySpawner()).thenReturn(enemySpawner);

        long time1 = 5499;
        long time2 = 5500;
        long time3 = 5501;

        enemyController.setLastSpawnTime(0);
        when(map.getSpawnCooldown()).thenReturn(6);

        enemyController.step(game, action, time1);
        Assertions.assertEquals(0, enemyController.getLastSpawnTime());

        enemyController.setSpawnOnPlatform(false);
        enemyController.step(game, action, time2);
        Assertions.assertEquals(5.5, enemyController.getLastSpawnTime());
        verify(enemySpawner, times(1)).spawn(any(Position.class));
        Assertions.assertTrue(enemyController.isSpawnOnPlatform());

        enemyController.step(game, action, time3);
        Assertions.assertEquals(5.5, enemyController.getLastSpawnTime());
    }
}
