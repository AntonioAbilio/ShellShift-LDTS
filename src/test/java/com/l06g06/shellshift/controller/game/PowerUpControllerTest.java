package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.PowerUpController;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.BulletPowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.StarPowerUp;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.game.spawners.PowerUpSpawner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PowerUpControllerTest {
    private Map map;
    private PowerUpController powerUpController;
    private Database database;

    @BeforeEach
    void setup() {
        this.map = mock(Map.class);
        powerUpController = new PowerUpController(map);

        Database.setInstance(this.database);
        database = Database.getInstance();
        database.setSound(true);
    }

    @Test
    void testLeftShift() {
        Position position = new Position(10,10);
        List<PowerUp> powerUps = new ArrayList<>(0);
        powerUps.add(new StarPowerUp(position));
        when(map.getPowerUps()).thenReturn(powerUps);

        powerUpController.left_shift();

        Position shiftedPosition = new Position(9,10);
        Assertions.assertEquals(shiftedPosition, powerUps.get(0).getPosition());
    }
    @Test
    void testSpawnOnPlatform() {
        List<Platform> platforms = new ArrayList<>();
        List<PowerUp> powerUps = new ArrayList<>(0);
        PowerUpSpawner powerUpSpawner = new PowerUpSpawner(powerUps);

        when(map.getPlatforms()).thenReturn(platforms);
        when(map.getPowerUpSpawner()).thenReturn(powerUpSpawner);
        when(map.getPowerUps()).thenReturn(powerUps);

        Platform platform1 = new Platform(new Position(199,10));
        platforms.add(platform1);
        powerUpController.spawnOnPlatform();
        Assertions.assertEquals(0, powerUps.size());

        platforms.remove(0);
        Platform platform2 = new Platform(new Position(200,10));
        platforms.add(platform2);

        powerUpController.spawnOnPlatform();
        Assertions.assertEquals(1,powerUps.size());
        Assertions.assertEquals(10,powerUps.get(0).getPosition().getY()+15);
        Assertions.assertTrue(powerUps.get(0).getPosition().getX() <= platforms.get(0).getPosition().getX() );

        powerUps.remove(0);
        platforms.remove(0);
        Platform platform3 = new Platform(new Position(201,10));
        platforms.add(platform3);

        powerUpController.spawnOnPlatform();
        Assertions.assertEquals(1,powerUps.size());
    }

    @Test
    public void testPowerUpCollision() {
        List<PowerUp> powerUps = new ArrayList<>();
        Chell chell = new Chell(new Position(3,1));
        Gun gun = new Gun(new NormalFireStrategy());

        when(map.getChell()).thenReturn(chell);
        when(map.getPowerUps()).thenReturn(powerUps);
        when(map.getGun()).thenReturn(gun);

        powerUps.add(new BulletPowerUp(new Position(1,0)));
        powerUpController.powerUpCollision();
        Assertions.assertEquals(0,powerUps.size());
        Assertions.assertEquals(50, gun.getNumBullets());

        powerUps.add(new BulletPowerUp(new Position(50,50)));
        powerUpController.powerUpCollision();
        Assertions.assertEquals(1,powerUps.size());
    }


    @Test
    public void testStepSpawnCondition() throws IOException {
        powerUpController.setLastSpawnTime(0);
        when(map.getSpawnCooldown()).thenReturn(0);

        Chell chell = new Chell(new Position(0,0));
        when(map.getChell()).thenReturn(chell);

        List<Platform> platforms = new ArrayList<>();
        platforms.add(new Platform(new Position(220,20)));
        when(map.getPlatforms()).thenReturn(platforms);

        List<PowerUp> powerUps = new ArrayList<>(0);
        PowerUpSpawner powerUpSpawner = new PowerUpSpawner(powerUps);
        when(map.getPowerUps()).thenReturn(powerUps);
        when(map.getPowerUpSpawner()).thenReturn(powerUpSpawner);

        powerUpController.step(mock(Game.class), Collections.emptyList(), 9999);
        Assertions.assertEquals(0, powerUps.size());

        powerUpController.step(mock(Game.class), Collections.emptyList(), 10000);
        Assertions.assertEquals(1, powerUps.size());

        powerUpController.setLastSpawnTime(0);
        powerUpController.step(mock(Game.class), Collections.emptyList(), 10001);
        Assertions.assertEquals(2, powerUps.size());
    }

    @Test
    public void testShiftConditionTest() throws IOException {
        powerUpController.setLastShiftTime(0);

        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(new BulletPowerUp(new Position(60,60)));
        when(map.getPowerUps()).thenReturn(powerUps);

        Chell chell = new Chell(new Position(0,0));
        when(map.getChell()).thenReturn(chell);

        when(map.getShiftCooldown()).thenReturn(5D);

        Position shiftedPosition = new Position(59,60);
        powerUpController.step(mock(Game.class), Collections.emptyList(), 4999);
        Assertions.assertNotEquals(shiftedPosition, powerUps.get(0).getPosition());

        powerUpController.step(mock(Game.class), Collections.emptyList(), 5000);
        Assertions.assertEquals(shiftedPosition, powerUps.get(0).getPosition());

        powerUpController.setLastShiftTime(0);
        Position shiftedPosition2 = new Position(58,60);
        powerUpController.step(mock(Game.class), Collections.emptyList(),5001);
        Assertions.assertEquals(shiftedPosition2, powerUps.get(0).getPosition());

    }

}
