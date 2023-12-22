package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.spawners.PlatformSpawner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlatformSpawnerTest {
    private PlatformSpawner platformSpawner;
    private List<Platform> platforms;

    @BeforeEach
    void setUp() {
        platforms = new ArrayList<>();
        platformSpawner = new PlatformSpawner(platforms);
    }

    @Test
    void spawnTest() {
        Position position = new Position(300, 50);
        platformSpawner.spawn(position);
        assertEquals(1, platforms.size());
        assertEquals(position.getX(), platforms.get(0).getPosition().getX());  // Y will be randomized and tested in the Creator
    }

    @Test
    void removeTest() {
        platforms.add(new Platform(new Position(-1, 40)));  // should be removed
        platformSpawner.spawn(new Position(10, 10));
        assertEquals(1, platforms.size());

        platforms.add(new Platform(new Position(0, 40)));  // should be removed
        platformSpawner.spawn(new Position(10, 10));
        assertEquals(2, platforms.size());

        platforms.add(new Platform(new Position(1, 40)));  // should not be removed
        platformSpawner.spawn(new Position(10, 10));
        assertEquals(4, platforms.size());
    }
}
