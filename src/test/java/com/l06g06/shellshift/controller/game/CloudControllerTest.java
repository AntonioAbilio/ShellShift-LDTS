package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.CloudController;
import com.l06g06.shellshift.model.game.elements.Cloud;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.game.spawners.CloudSpawner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class CloudControllerTest {
    private Map map;
    private CloudController cloudController;
    @BeforeEach
    void setup() {
        this.map = mock(Map.class);
        this.cloudController = new CloudController(map);
    }

    @Test
    void testLeftShift() {
        Position position = new Position(10, 10);
        List<Cloud> clouds = Arrays.asList(new Cloud(position));
        when(map.getClouds()).thenReturn(clouds);

        cloudController.left_shift();

        Position shiftedPosition = new Position(9, 10);
        Assertions.assertEquals(shiftedPosition, clouds.get(0).getPosition());

    }

    @Test
    void testSpawn() {
        List<Cloud> clouds = new ArrayList<>(0);
        CloudSpawner cloudSpawner = new CloudSpawner(clouds);
        when(map.getCloudSpawner()).thenReturn(cloudSpawner);

        cloudController.spawn();

        Assertions.assertEquals(1, clouds.size());
    }

    @Test
    void testShiftConditionStep() throws IOException {
        when(map.getShiftCooldown()).thenReturn(0D);

        Position position = new Position(10,10);
        List<Cloud> clouds = new ArrayList<>();
        clouds.add(new Cloud(position));
        when(map.getClouds()).thenReturn(clouds);

        cloudController.setLastShiftTime(0);

        cloudController.step(mock(Game.class), Collections.emptyList(), 149);
        Assertions.assertEquals(position, clouds.get(0).getPosition());

        Position shiftedPosition = new Position(9,10);
        cloudController.step(mock(Game.class), Collections.emptyList(), 150);
        Assertions.assertEquals(shiftedPosition, clouds.get(0).getPosition());

        cloudController.setLastShiftTime(0);
        Position shiftedPosition2 = new Position(8,10);
        cloudController.step(mock(Game.class), Collections.emptyList(), 151);
        Assertions.assertEquals(shiftedPosition2, clouds.get(0).getPosition());

    }
    @Test
    void testSpawnConditionStep() throws IOException {
        when(map.getSpawnCooldown()).thenReturn(0);

        List<Cloud> clouds = new ArrayList<>();
        CloudSpawner cloudSpawner = new CloudSpawner(clouds);
        when(map.getCloudSpawner()).thenReturn(cloudSpawner);

        cloudController.setLastSpawnTime(0);

        cloudController.step(mock(Game.class), Collections.emptyList(), 14999);
        Assertions.assertEquals(0, clouds.size());

        cloudController.step(mock(Game.class), Collections.emptyList(), 15000);
        Assertions.assertEquals(1, clouds.size());

        cloudController.setLastSpawnTime(0);
        cloudController.step(mock(Game.class), Collections.emptyList(), 15001);
        Assertions.assertEquals(2, clouds.size());
    }
}
