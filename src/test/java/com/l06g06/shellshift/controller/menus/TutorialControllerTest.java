package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.controller.game.elements.BulletController;
import com.l06g06.shellshift.controller.game.elements.ChellController;
import com.l06g06.shellshift.controller.game.elements.CloudController;
import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.game.spawners.PlatformSpawner;
import com.l06g06.shellshift.model.tutorial.TutorialMap;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.Game;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.LongRange;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class TutorialControllerTest {

    private TutorialMap tutorialMap;
    private TutorialController tutorialController;
    private Game game;

    @BeforeEach
    void setUp(){
        tutorialMap = new TutorialMap();
        tutorialController = new TutorialController(tutorialMap);
        game = mock(Game.class);
    }

    @Test
    void jumpTest() {
        // Test jumping behavior
        long currentTime = System.currentTimeMillis();
        tutorialController.jump(currentTime);
        assertTrue(tutorialController.isJumping);
    }

    @Test
    void jumpUpdateTest() {
        // Test updating position during jump
        long currentTime = System.currentTimeMillis();
        tutorialController.jump(currentTime);
        tutorialController.jumpUpdate(currentTime + 4000);
        assertFalse(tutorialController.isJumping); // Ensure jumping is false after reaching the ground
    }

    @Test
    void moveLeftTest() {
        // Test moving left
        tutorialMap.getChell().setDirection(true);
        int initialX = tutorialMap.getChell().getPosition().getX();
        tutorialController.moveLeft();
        assertEquals(initialX - 1, tutorialMap.getChell().getPosition().getX());
        assertFalse(tutorialMap.getChell().isDirection());

        tutorialMap.setChell(new Chell(new Position(24, 5)));
        tutorialController.moveLeft();
        assertEquals(new Position(24, 5), tutorialMap.getChell().getPosition());

        tutorialMap.setChell(new Chell(new Position(25, 5)));
        tutorialController.moveLeft();
        assertEquals(new Position(25, 5), tutorialMap.getChell().getPosition());

        tutorialMap.setChell(new Chell(new Position(26, 5)));
        tutorialController.moveLeft();
        assertEquals(new Position(25, 5), tutorialMap.getChell().getPosition());
    }

    @Test
    void moveRightTest() {
        // Test moving right
        tutorialMap.getChell().setDirection(false);
        int initialX = tutorialMap.getChell().getPosition().getX();
        tutorialController.moveRight();
        assertEquals(initialX + 1, tutorialMap.getChell().getPosition().getX());
        assertTrue(tutorialMap.getChell().isDirection());

        tutorialMap.setChell(new Chell(new Position(80, 5)));
        tutorialController.moveRight();
        assertEquals(new Position(81, 5), tutorialMap.getChell().getPosition());

        tutorialMap.setChell(new Chell(new Position(81, 5)));
        tutorialController.moveRight();
        assertEquals(new Position(81, 5), tutorialMap.getChell().getPosition());

        tutorialMap.setChell(new Chell(new Position(82, 5)));
        tutorialController.moveRight();
        assertEquals(new Position(82, 5), tutorialMap.getChell().getPosition());
    }

    @Test
    void fireTest() {
        // Test firing bullets
        long currentTime = System.currentTimeMillis();
        tutorialController.fire(currentTime);
        assertEquals(1, tutorialMap.getBullets().size());
    }

    @Test
    void fireConditionTest(){
        Gun gun = mock(Gun.class);
        when(gun.getReloadTime()).thenReturn(500.0);
        when(gun.getNumBullets()).thenReturn(1);
        tutorialMap.setGun(gun);
        Chell chell = new Chell(new Position(16, 6));
        tutorialMap.setChell(chell);
        long time = 1000;
        when(gun.getReloadTime()).thenReturn(800.0);

        tutorialController.setReloadStartTime(201);
        tutorialController.fire(time);
        assertEquals(0, tutorialMap.getBullets().size());

        tutorialController.setReloadStartTime(200);
        tutorialController.fire(time);
        assertEquals(1, tutorialMap.getBullets().size());

        tutorialController.setReloadStartTime(199);
        tutorialController.fire(time);
        assertEquals(2, tutorialMap.getBullets().size());

        tutorialController.setReloadStartTime(199);
        when(gun.getNumBullets()).thenReturn(0);
        tutorialController.fire(time);
        assertEquals(2, tutorialMap.getBullets().size());   // waited enough time, but no bullets
    }

    @Test
    void fireWithDirectionTest() {
        long time = 1000;
        Gun gun = mock(Gun.class);
        when(gun.getReloadTime()).thenReturn(500.0);
        when(gun.getNumBullets()).thenReturn(1);
        tutorialMap.setGun(gun);
        Chell chell = new Chell(new Position(16, 5));
        chell.setDirection(false); // Chell is looking to the left
        tutorialMap.setChell(chell);

        assertEquals(0, tutorialMap.getBullets().size());
        tutorialController.fire(time);
        verify(gun, times(1)).decreaseNumBullet();
        assertEquals(1, tutorialMap.getBullets().size());
        assertEquals(new Position(0, 0), tutorialMap.getBullets().get(0).getPosition());
        assertFalse(tutorialMap.getBullets().get(0).isDirection());

        chell.setDirection(true); // Chell is looking to the right
        tutorialController.fire(time + 1000);
        assertEquals(2, tutorialMap.getBullets().size());
        assertEquals(new Position(16, 0), tutorialMap.getBullets().get(1).getPosition());
        assertTrue(tutorialMap.getBullets().get(1).isDirection());
    }

    @Test
    void bulletUpdateTest() {
        // Test updating bullet positions
        Bullet bullet1 = new Bullet(new Position(10, 20));
        Bullet bullet2 = new Bullet(new Position(5, 16));
        bullet1.setDirection(true);  // right
        bullet2.setDirection(false); // left
        List<Bullet> bullets = new ArrayList<>();
        bullets.add(bullet1);
        bullets.add(bullet2);
        tutorialMap.setBullets(bullets);
        tutorialController.bulletUpdate();
        assertEquals(new Position(12, 20), tutorialMap.getBullets().get(0).getPosition());
        assertEquals(new Position(3, 16), tutorialMap.getBullets().get(1).getPosition());
    }

    @Test
    void bulletCollisionTest() {
        List<Bullet> bullets = new ArrayList<>();
        Bullet bullet1 = new Bullet(new Position(1,  0));
        Bullet bullet2 = new Bullet(new Position(5, 5));
        Bullet bullet3 = new Bullet(new Position(2, 9));
        bullet1.setDirection(true); // right
        bullet2.setDirection(false); // left
        bullet3.setDirection(true); // right
        bullet1.setDamageMultiplier(1);
        bullet1.setDamageMultiplier(1);
        bullet1.setDamageMultiplier(1);
        bullets.add(bullet1);
        bullets.add(bullet2);
        bullets.add(bullet3);
        tutorialMap.setBullets(bullets);
        List<Enemy> enemies = new ArrayList<>();
        MoveStrategy mockedMoveStrategy = mock(MoveStrategy.class);
        Enemy enemy1 = new SoftMonster(new Position(-12,  -13), mockedMoveStrategy);
        Enemy enemy2 = new HardMonster(new Position(16, 5), mockedMoveStrategy);
        Enemy enemy3 = new SoftMonster(new Position(32, 9), mockedMoveStrategy);
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        tutorialMap.setEnemies(enemies);

        Assertions.assertEquals(3, bullets.size());
        Assertions.assertEquals(3, enemies.size());
        tutorialController.bulletCollision();
        Assertions.assertEquals(2, bullets.size());
        Assertions.assertEquals(2, enemies.size());
    }

    @Test
    void leftShiftTest() {
        // Test background shift
        Cloud cloud1 = new Cloud(new Position(-31, 5));
        Cloud cloud2 = new Cloud(new Position(-30, 5));
        List<Cloud> clouds = new ArrayList<>();
        clouds.add(cloud1);
        clouds.add(cloud2);
        tutorialMap.setClouds(clouds);
        tutorialController.setDelayBackground(true);
        List<Coin> coins = Arrays.asList(new Coin(new Position(10, 20)));
        tutorialMap.setCoins(coins);
        tutorialController.leftShift();
        assertEquals(9, tutorialMap.getCoins().get(0).getPosition().getX());

        tutorialController.setDelayBackground(false);
        tutorialController.leftShift();
        Assertions.assertTrue(tutorialController.delayBackground);
    }

    @Test
    void coinCollisionTest() {
        // Test collecting coins
        List<Coin> coins = new ArrayList<>();
        Coin coin1 = new Coin(new Position(1,  0));
        Coin coin2 = new Coin(new Position(5, 5));
        Coin coin3 = new Coin(new Position(2, 9));
        coins.add(coin1);
        coins.add(coin2);
        coins.add(coin3);
        tutorialMap.setCoins(coins);
        Chell chell = new Chell(new Position(3, 1)); // Chell intersects coin in this position
        tutorialMap.setChell(chell);

        assertEquals(3, tutorialMap.getCoins().size());
        tutorialController.coinCollision();

        assertEquals(1, tutorialMap.getCoinsCollected());
        assertEquals(2, tutorialMap.getCoins().size());
    }

    @Test
    void stepJumpTest() throws IOException {
        // Test step()
        List<Gui.PressedKey> keys = new ArrayList<>();
        keys.add(Gui.PressedKey.UP);
        long currentTime = System.currentTimeMillis();
        tutorialController.step(game, keys, currentTime);
        assertTrue(tutorialMap.isSelectedArrowUp());
        assertTrue(tutorialController.isJumping);
    }

    @Test
    void stepFireTest() throws IOException {
        tutorialController.setCoinCheckpoint(true);
        List<Gui.PressedKey> actions = Arrays.asList(Gui.PressedKey.FIRE);
        long time = 1000;
        TutorialController tutorialControllerSpy = Mockito.spy(tutorialController);
        tutorialControllerSpy.step(game, actions, time);
        Assertions.assertTrue(tutorialMap.isSelectedSpace());
        Mockito.verify(tutorialControllerSpy, Mockito.times(1)).fire(eq(time));
        Mockito.verify(tutorialControllerSpy, Mockito.times(1)).bulletUpdate();
        Mockito.verify(tutorialControllerSpy, Mockito.times(1)).bulletCollision();
    }

    @Test
    void stepCallTest() throws IOException {
        tutorialController.setCoinCheckpoint(true);
        tutorialMap.setEnemies(new ArrayList<>());
        List<Gui.PressedKey> actions = Arrays.asList(Gui.PressedKey.LEFT, Gui.PressedKey.RIGHT, Gui.PressedKey.EXIT);
        long time = 1000;
        TutorialController tutorialControllerSpy = Mockito.spy(tutorialController);
        tutorialControllerSpy.step(game, actions, time);
        Mockito.verify(tutorialControllerSpy, Mockito.times(1)).moveLeft();
        Assertions.assertTrue(tutorialMap.isSelectedArrowLeft());
        Mockito.verify(tutorialControllerSpy, Mockito.times(1)).moveRight();
        Assertions.assertTrue(tutorialMap.isSelectedArrowRight());
        Mockito.verify(tutorialControllerSpy, Mockito.times(1)).bulletUpdate();
        Mockito.verify(tutorialControllerSpy, Mockito.times(1)).bulletCollision();
        Mockito.verify(tutorialControllerSpy, Mockito.times(1)).coinCollision();
    }

    @Test
    void stepShiftConditionTest() throws IOException {
        List<Gui.PressedKey> actions = new ArrayList<>();
        long time1 = 79;
        long time2 = 80;
        long time3 = 81;

        tutorialController.step(game, actions, time1);
        Assertions.assertEquals(0, tutorialController.getLastShiftTime());
        tutorialController.step(game, actions, time2);
        Assertions.assertEquals(0.08, tutorialController.getLastShiftTime());
        TutorialController tutorialControllerSpy = spy(tutorialController);
        tutorialControllerSpy.setLastShiftTime(0);
        tutorialControllerSpy.step(game, actions, time2);
        verify(tutorialControllerSpy, times(1)).leftShift();
        tutorialController.step(game, actions, time3);
        Assertions.assertEquals(0.08, tutorialController.getLastShiftTime());
    }

}