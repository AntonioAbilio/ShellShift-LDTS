package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.controller.game.elements.PowerUpController;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.StarPowerUp;
import com.l06g06.shellshift.model.game.map.Map;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PowerUpControllerTest {
    private Map map;
    private PowerUpController powerUpController;

    @BeforeEach
    void setup() {
        this.map = mock(Map.class);
        powerUpController = new PowerUpController(map);
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
    @Property
    void testSpawnOnPlatform(@ForAll @IntRange(max=200) int x) {
        List<Platform> platforms = new ArrayList<>(0);
        platforms.add(new Platform(new Position(x, 10)));
        when(map.getPlatforms()).thenReturn(platforms);

        powerUpController.spawnOnPlatform();

        verify(map, times(0)).getPowerUpSpawner();
    }
}
