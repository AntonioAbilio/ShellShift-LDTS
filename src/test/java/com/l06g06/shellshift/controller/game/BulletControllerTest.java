package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.BulletController;
import com.l06g06.shellshift.controller.game.elements.CoinController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;
import com.l06g06.shellshift.model.game.map.Map;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BulletControllerTest {
    private Map mockedMap ;
    private List<Bullet> bullets;
    private BulletController bulletController;

    @BeforeEach
    void setup(){
        Database.getInstance().setSound(true);  // ToDo: Turn off sound on every test class
        this.mockedMap = mock(Map.class);
        this.bullets = new ArrayList<>();
        this.bulletController = new BulletController(mockedMap);

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
        Mockito.when(mockedMap.getBullets()).thenReturn(bullets);
    }

    @Test
    void stepTest(){
        Game game = mock(Game.class);
        List<Gui.PressedKey> actions = Arrays.asList(Gui.PressedKey.FIRE);
        long time = 1000;
        Position chellPosition = new Position(3, 1);
        Chell chell = new Chell(chellPosition);
        Mockito.when(mockedMap.getChell()).thenReturn(chell);
        Gun gun = mock(Gun.class);
        when(gun.getReloadTime()).thenReturn(1000.0);
        when(mockedMap.getGun()).thenReturn(gun);
        BulletController bulletControllerSpy = Mockito.spy(bulletController);
        bulletControllerSpy.step(game, actions, time);
        Mockito.verify(bulletControllerSpy, Mockito.times(1)).fire(eq(time));
        Mockito.verify(bulletControllerSpy, Mockito.times(1)).bulletUpdate();
        Mockito.verify(bulletControllerSpy, Mockito.times(1)).bulletCollision();
        Mockito.verify(bulletControllerSpy, Mockito.times(1)).removeOutOfBoundsBullets();
    }


    @Test
    void bulletUpdateTest(){
        bulletController.bulletUpdate();
        Assertions.assertEquals(new Position(4, 0), bullets.get(0).getPosition());
        Assertions.assertEquals(new Position(2, 5), bullets.get(1).getPosition());
        Assertions.assertEquals(new Position(5, 9), bullets.get(2).getPosition());
    }

    @Test
    void bulletCollisionTest(){
        Map map = new Map();
        map.setScore(0);
        map.setBullets(bullets);
        bulletController = new BulletController(map);
        List<Enemy> enemies = new ArrayList<>();
        MoveStrategy mockedMoveStrategy = mock(MoveStrategy.class);
        Enemy enemy1 = new SoftMonster(new Position(-12,  -13), mockedMoveStrategy);
        Enemy enemy2 = new HardMonster(new Position(16, 5), mockedMoveStrategy);
        Enemy enemy3 = new SoftMonster(new Position(32, 9), mockedMoveStrategy);
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        map.setEnemies(enemies);

        Assertions.assertEquals(3, bullets.size());
        Assertions.assertEquals(3, enemies.size());
        bulletController.bulletCollision();
        Assertions.assertEquals(2, bullets.size());
        Assertions.assertEquals(2, enemies.size());
        Assertions.assertEquals(1, map.getMonstersKilled());
    }

    @Test
    void fireWithReloadTimeTest() {
        long time = 1000;
        Gun gun = mock(Gun.class);
        when(gun.getReloadTime()).thenReturn(500.0);
        when(gun.getNumBullets()).thenReturn(1);
        when(mockedMap.getGun()).thenReturn(gun);
        Chell chell = new Chell(new Position(4, 4));
        when(mockedMap.getChell()).thenReturn(chell);
        bulletController.fire(time);
        verify(gun, times(1)).decreaseNumBullet();
    }

    @Test
    void fireConditionTest(){
        Map map = new Map();
        bulletController = new BulletController(map);
        Gun gun = mock(Gun.class);
        when(gun.getReloadTime()).thenReturn(500.0);
        when(gun.getNumBullets()).thenReturn(1);
        map.setGun(gun);
        Chell chell = new Chell(new Position(16, 6));
        map.setChell(chell);
        long time = 1000;
        when(gun.getReloadTime()).thenReturn(800.0);

        bulletController.setReloadStartTime(201);
        bulletController.fire(time);
        assertEquals(0, map.getBullets().size());

        bulletController.setReloadStartTime(200);
        bulletController.fire(time);
        assertEquals(1, map.getBullets().size());

        bulletController.setReloadStartTime(199);
        bulletController.fire(time);
        assertEquals(2, map.getBullets().size());

        bulletController.setReloadStartTime(199);
        when(gun.getNumBullets()).thenReturn(0);
        bulletController.fire(time);
        assertEquals(2, map.getBullets().size());   // waited enough time, but no bullets
    }

    @Test
    void fireWithoutBulletsTest() {
        long time = 1000;
        Gun gun = mock(Gun.class);
        when(gun.getReloadTime()).thenReturn(500.0);
        when(gun.getNumBullets()).thenReturn(0);
        when(mockedMap.getGun()).thenReturn(gun);
        bulletController.fire(time);
        verify(gun, times(0)).decreaseNumBullet();
    }

    @Test
    void fireWithDirectionTest() {
        Map map = new Map();
        bulletController = new BulletController(map);
        long time = 1000;
        Gun gun = mock(Gun.class);
        when(gun.getReloadTime()).thenReturn(500.0);
        when(gun.getNumBullets()).thenReturn(1);
        map.setGun(gun);
        Chell chell = new Chell(new Position(16, 6));
        chell.setDirection(false); // Chell is looking to the left
        map.setChell(chell);

        assertEquals(0, map.getBullets().size());
        bulletController.fire(time);
        assertEquals(1, map.getBullets().size());
        assertEquals(new Position(0, 0), map.getBullets().get(0).getPosition());
        assertFalse(map.getBullets().get(0).isDirection());

        chell.setDirection(true); // Chell is looking to the right
        bulletController.fire(time + 1000);
        assertEquals(2, map.getBullets().size());
        assertEquals(new Position(16, 0), map.getBullets().get(1).getPosition());
        assertTrue(map.getBullets().get(1).isDirection());
    }

    @Test
    void removeOutOfBoundsBulletsTest(){
        Map map = new Map();
        bulletController = new BulletController(map);
        map.setBullets(bullets);
        bullets.add(new Bullet(new Position(-400, 5)));
        bullets.add(new Bullet(new Position(-4, 5)));
        bullets.add(new Bullet(new Position(-5, 8)));
        bullets.add(new Bullet(new Position(-6, -6)));
        bullets.add(new Bullet(new Position(189, 100)));
        bullets.add(new Bullet(new Position(190, 100)));
        bullets.add(new Bullet(new Position(191, 100)));
        bullets.add(new Bullet(new Position(200, 10)));

        Assertions.assertEquals(11, map.getBullets().size());
        bulletController.removeOutOfBoundsBullets();
        Assertions.assertEquals(7, map.getBullets().size());
    }
}

