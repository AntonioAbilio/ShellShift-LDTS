package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.SpeedPowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.StarPowerUp;
import com.l06g06.shellshift.model.game.spawners.PowerUpSpawner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerUpSpawnerTest {
    private PowerUpSpawner powerUpSpawner;
    private List<PowerUp> powerUps;

    @BeforeEach
    void setUp() {
        Database.getInstance().setSound(true);
        this.powerUps = new ArrayList<>();
        this.powerUpSpawner = new PowerUpSpawner(powerUps);
    }

    @Test
    void spawnTest() {
        Position position = new Position(50, 50);
        powerUpSpawner.spawn(position);
        assertEquals(1, powerUps.size());
        assertEquals(position.getX(), powerUps.get(0).getPosition().getX()); // Y will be randomized and tested in the Creator
    }

    @Test
    void removeTest() {
        powerUps.add(new StarPowerUp(new Position(-21, 40)));  // should be removed
        powerUpSpawner.spawn(new Position(10, 10));
        assertEquals(1, powerUps.size());

        powerUps.add(new SpeedPowerUp(new Position(-20, 40)));  // should be removed
        powerUpSpawner.spawn(new Position(10, 10));
        assertEquals(2, powerUps.size());

        powerUps.add(new StarPowerUp(new Position(-19, 40)));  // should not be removed
        powerUpSpawner.spawn(new Position(10, 10));
        assertEquals(4, powerUps.size());
    }
}
