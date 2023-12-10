package com.l06g06.shellshift.model.game.elements.moveStrategies;

import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.VerticalMoveStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerticalMoveStrategyTest {
    private VerticalMoveStrategy verticalMoveStrategy;

    @BeforeEach
    void setUp() {
        verticalMoveStrategy = new VerticalMoveStrategy();
    }

    @Test
    void moveUpTest() {
        Position currentPos = new Position(10, 10);
        for (int i = 0; i < 20; i++) {
            currentPos = verticalMoveStrategy.move(currentPos);
            assertEquals(10, currentPos.getX());
            assertEquals(10 - i - 1 , currentPos.getY());
        }
    }

    @Test
    void moveDownTest() {
        Position currentPos = new Position(10, 10);

        // Move up first
        for (int i = 0; i < 20; i++) {
            currentPos = verticalMoveStrategy.move(currentPos);
        }

        // Move down
        for (int i = 0; i < 20; i++) {
            currentPos = verticalMoveStrategy.move(currentPos);
            assertEquals(10, currentPos.getX());
            assertEquals(-10 + i + 1, currentPos.getY());
        }
    }
}
