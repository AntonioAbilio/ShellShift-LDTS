package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class MapTest {
    private Map map;

    @BeforeEach
    public void setUp() {
        map = new Map();
    }

    @Test
    public void getChellTest() {
        assertNotNull(map.getChell());
    }

    @Test
    public void setChellTest() {
        Chell chell = new Chell(new Position(120, 0));
        map.setChell(chell);
        assertEquals(chell, map.getChell());
    }

    @Test
    public void getGunTest() {
        assertNotNull(map.getGun());
    }

    @Test
    public void setGunTest() {
        FireStrategy fireStrategy = mock(FireStrategy.class);
        Gun gun = new Gun(fireStrategy);
        map.setGun(gun);
        assertEquals(gun, map.getGun());
    }

    @Test
    public void getEnemiesTest() {
        assertNotNull(map.getEnemies());
    }

    @Test
    public void setEnemiesTest() {
        MoveStrategy moveStrategy = mock(MoveStrategy.class);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new HardMonster(new Position(100, 100), moveStrategy));
        map.setEnemies(enemies);
        assertEquals(enemies, map.getEnemies());
    }

    @Test
    public void getPlatformsTest() {
        assertNotNull(map.getPlatforms());
    }

    @Test
    public void getBulletsTest() {
        assertNotNull(map.getBullets());
    }

    @Test
    public void addBulletTest() {
        Bullet bullet = new Bullet(new Position(100, 100));
        map.addBullet(bullet);
        assertTrue(map.getBullets().contains(bullet));
    }

    @Test
    public void getPowerUpsTest() {
        assertNotNull(map.getPowerUps());
    }

    @Test
    public void getCoinsTest() {
        assertNotNull(map.getCoins());
    }

    @Test
    public void getPlatformSpawnerTest() {
        assertNotNull(map.getPlatformSpawner());
    }

    @Test
    public void getCoinSpawnerTest() {
        assertNotNull(map.getCoinSpawner());
    }

    @Test
    public void getEnemySpawnerTest() {
        assertNotNull(map.getEnemySpawner());
    }

    @Test
    public void getScoreTest() {
        assertEquals(0, map.getScore());
    }

    @Test
    public void setScoreTest() {
        map.setScore(10);
        assertEquals(10, map.getScore());
    }
}