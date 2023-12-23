package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import com.l06g06.shellshift.model.game.elements.powerups.ActivePowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.SpeedPowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.StarPowerUp;
import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.spawners.PowerUpSpawner;
import net.jqwik.api.Data;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Property
    void testGetPowerUps(@ForAll @Positive int x, @ForAll @Positive int y) {
        map = new Map();
        List<PowerUp> expectedPowerUps = Arrays.asList(new SpeedPowerUp(new Position(x,y)), new StarPowerUp(new Position(y,y))); // Replace with expected values or mock objects
        map.setPowerUps(expectedPowerUps);
        assertEquals(expectedPowerUps, map.getPowerUps());
        assertEquals(2, map.getPowerUps().size());
        assertEquals(x, map.getPowerUps().get(0).getPosition().getX());
        assertEquals(y, map.getPowerUps().get(0).getPosition().getY());
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

        map.setScore(Database.getInstance().getMAXSCORE()-1);
        assertEquals(Database.getInstance().getMAXSCORE()-1, map.getScore());

        map.setScore(Database.getInstance().getMAXSCORE());
        assertEquals(Database.getInstance().getMAXSCORE(), map.getScore());

        map.setScore(Database.getInstance().getMAXSCORE()+1);
        assertEquals(Database.getInstance().getMAXSCORE(), map.getScore());

        map.setScore(99999999);
        assertEquals(Database.getInstance().getMAXSCORE(), map.getScore());
    }

    @Test
    public void coinsSettersAndGetters(){
        Assertions.assertEquals(0, map.getCoinsCollected());
        for (int i = 1; i != 1000; i++){
            map.addCoin();
            Assertions.assertEquals(i, map.getCoinsCollected());
        }
    }

    @Property
    void testSetCoins(@ForAll @Positive int x, @ForAll @Positive int y) {
        map = new Map();
        List<Coin> expectedCoins = Arrays.asList(new Coin(new Position(x,y)), new Coin(new Position(x,x))); // Replace with expected values or mock objects
        map.setCoins(expectedCoins);
        assertEquals(expectedCoins, map.getCoins());
        assertEquals(2, map.getCoins().size());
        assertEquals(x, map.getCoins().get(0).getPosition().getX());
        assertEquals(y, map.getCoins().get(0).getPosition().getY());
    }

    @Test
    public void monstersSettersAndGetters(){
        Assertions.assertEquals(0, map.getMonstersKilled());
        for (int i = 1; i != 1000; i++){
            map.addMonsterKilled();
            Assertions.assertEquals(i, map.getMonstersKilled());
        }
    }

    @Test
    public void cloudSettersAndGetters(){
        Assertions.assertEquals(0, map.getClouds().size());
        map.addCloudSkipTask();
        Assertions.assertEquals(1, map.getClouds().size());
        Assertions.assertEquals(160, map.getClouds().get(0).getPosition().getX());
        int y = map.getClouds().get(0).getPosition().getY();
        if (!(y >= 8 && y <= 8 + 69)) fail();

    }

    @Test
    void testGetGameStartTime() {
        long expectedStartTime = 12345L;
        map.setGameStartTime(expectedStartTime);
        assertEquals(expectedStartTime, map.getGameStartTime());
    }

    @Test
    void testGetShiftCooldown() {
        double expectedCooldown = 2.5;
        map.setShiftCooldown(expectedCooldown);
        assertEquals(expectedCooldown, map.getShiftCooldown(), 0.0001);
    }

    @Test
    void testGetSpawnCooldown() {
        int expectedCooldown = 10;
        map.setSpawnCooldown(expectedCooldown);
        assertEquals(expectedCooldown, map.getSpawnCooldown());
    }

    @Test
    void testSetGameStartTime() {
        long expectedStartTime = 54321L;
        map.setGameStartTime(expectedStartTime);
        assertEquals(expectedStartTime, map.getGameStartTime());
    }

    @Test
    void testSetShiftCooldown() {
        double expectedCooldown = 3.5;
        map.setShiftCooldown(expectedCooldown);
        assertEquals(expectedCooldown, map.getShiftCooldown());
    }

    @Test
    void testSetSpawnCooldown() {
        int expectedCooldown = 15;
        map.setSpawnCooldown(expectedCooldown);
        assertEquals(expectedCooldown, map.getSpawnCooldown());
    }

    @Test
    void testGetPowerUpSpawner() {
        assertNotNull(map.getPowerUpSpawner());
        assertTrue(map.getPowerUpSpawner() instanceof PowerUpSpawner);
    }

    @Test
    void testGetActivePowerUp() {
        assertNotNull(map.getActivePowerUp());
        assertTrue(map.getActivePowerUp() instanceof ActivePowerUp);
    }

    @Property
    void testSetPlatforms(@ForAll @Positive int x, @ForAll @Positive int y) {
        map = new Map();
        List<Platform> expectedPlatforms = Arrays.asList(new Platform(new Position(x,y)), new Platform(new Position(y,y)));
        map.setPlatforms(expectedPlatforms);
        assertEquals(expectedPlatforms, map.getPlatforms());
        assertEquals(2, map.getPlatforms().size());
        assertEquals(x, map.getPlatforms().get(0).getPosition().getX());
        assertEquals(y, map.getPlatforms().get(0).getPosition().getY());
    }

}