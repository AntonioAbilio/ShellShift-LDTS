package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.spawners.EnemySpawner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemySpawnerTest {
    private EnemySpawner enemySpawner;
    private List<Enemy> enemies;

    @BeforeEach
    void setUp() {
        enemies = new ArrayList<>();
        enemySpawner = new EnemySpawner(enemies);
    }

    @Test
    void spawnTest() {
        Position position = new Position(50, 50);
        enemySpawner.spawn(position);
        assertEquals(1, enemies.size());
        assertEquals(position.getX(), enemies.get(0).getPosition().getX());  // Y will be randomized and tested in the Creator
    }

    @Test
    void removeTest() {
        Position position = new Position(-30, 40);
        enemySpawner.spawn(position);
        assertEquals(0, enemies.size());
    }
}
