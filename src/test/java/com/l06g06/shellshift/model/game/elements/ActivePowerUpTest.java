package com.l06g06.shellshift.model.game.elements;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.powerups.ActivePowerUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivePowerUpTest {
    private ActivePowerUp activePowerUp;

    @BeforeEach
    void setUp() {
        Database.getInstance().setSound(true);
        activePowerUp = new ActivePowerUp();
    }

    @Test
    void addOrUpdateActivePowerUpTest() {
        String powerUp = "SpeedBoost";
        Long duration = 5000L;
        activePowerUp.addOrUpdateActivePowerUp(powerUp, duration);
        assertEquals(duration, activePowerUp.getDuration(powerUp));
    }

    @Test
    void removePowerUpTest() {
        String powerUp = "SpeedBoost";
        Long duration = 5000L;
        activePowerUp.addOrUpdateActivePowerUp(powerUp, duration);
        activePowerUp.removePowerUp(powerUp);
        assertEquals(0, activePowerUp.getPowerUpsAndDuration().size());
    }

    @Test
    void getDurationTest() {
        String powerUp = "SpeedBoost";
        Long duration = 5000L;
        activePowerUp.addOrUpdateActivePowerUp(powerUp, duration);
        assertEquals(duration, activePowerUp.getDuration(powerUp));
    }
}
