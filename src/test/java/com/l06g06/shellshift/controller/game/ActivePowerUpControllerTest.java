package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.ActivePowerUpController;
import com.l06g06.shellshift.model.game.elements.powerups.ActivePowerUp;
import com.l06g06.shellshift.model.game.map.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class ActivePowerUpControllerTest {
    private Map map;
    private ActivePowerUpController activePowerUpController;

    @BeforeEach
    void setup() {
        this.map = mock(Map.class);
        this.activePowerUpController = new ActivePowerUpController(map);
    }

    @Test
    void testStep_UpdateDuration() {
        ActivePowerUp activePowerUp = new ActivePowerUp();
        activePowerUp.addOrUpdateActivePowerUp("Star", 5000L);

        when(map.getActivePowerUp()).thenReturn(activePowerUp);
        activePowerUpController.setLastTimeCalled(0);

        activePowerUpController.step(mock(Game.class), Collections.emptyList(), 999);
        Assertions.assertEquals(activePowerUp.getDuration("Star"), 5000);

        activePowerUpController.step(mock(Game.class), Collections.emptyList(), 1000);
        Assertions.assertEquals(activePowerUp.getDuration("Star"), 4000L);

        activePowerUpController.setLastTimeCalled(0);
        activePowerUpController.step(mock(Game.class), Collections.emptyList(), 1001);
        Assertions.assertEquals(activePowerUp.getDuration("Star"), 3000L);


    }

    @Test
    void testStep_Remove() {
        ActivePowerUp activePowerUp = new ActivePowerUp();
        activePowerUp.addOrUpdateActivePowerUp("Test1", 1000L);
        activePowerUp.addOrUpdateActivePowerUp("Test2", 1001L);
        activePowerUp.addOrUpdateActivePowerUp("Test3", 999L);

        when(map.getActivePowerUp()).thenReturn(activePowerUp);
        activePowerUpController.setLastTimeCalled(0);

        activePowerUpController.step(mock(Game.class), Collections.emptyList(), 999);
        Assertions.assertEquals(activePowerUp.getPowerUpsAndDuration().size(), 3);

        activePowerUpController.step(mock(Game.class), Collections.emptyList(), 1000);
        Assertions.assertEquals(activePowerUp.getPowerUpsAndDuration().size(), 1);

        activePowerUp.addOrUpdateActivePowerUp("Test1", 1000L);
        activePowerUp.addOrUpdateActivePowerUp("Test2", 1001L);
        activePowerUpController.setLastTimeCalled(0);

        activePowerUpController.step(mock(Game.class), Collections.emptyList(), 1000);
        Assertions.assertEquals(activePowerUp.getPowerUpsAndDuration().size(), 1);

    }
}
