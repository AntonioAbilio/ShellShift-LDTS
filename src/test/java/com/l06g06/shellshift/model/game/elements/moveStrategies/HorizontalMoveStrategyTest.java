package com.l06g06.shellshift.model.game.elements.moveStrategies;

import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HorizontalMoveStrategyTest {
    private HorizontalMoveStrategy horizontalMoveStrategy;

    @BeforeEach
    void setUp() {
        horizontalMoveStrategy = new HorizontalMoveStrategy();
    }

    @Test
    void moveLeftTest() {
        Position currentPos = new Position(10, 10);
        for (int i = 0; i < 20; i++) {
            currentPos = horizontalMoveStrategy.move(currentPos);
            Assertions.assertEquals(10 - i - 1, currentPos.getX());
            Assertions.assertEquals(10, currentPos.getY());
        }
    }

    @Test
    void moveRightTest() {
        Position currentPos = new Position(10, 10);

        // Move to the left first
        for (int i = 0; i < 20; i++) {
            currentPos = horizontalMoveStrategy.move(currentPos);
        }

        // Move right
        for (int i = 0; i < 20; i++) {
            currentPos = horizontalMoveStrategy.move(currentPos);
            Assertions.assertEquals(-10 + i + 1, currentPos.getX());
            Assertions.assertEquals(10, currentPos.getY());
        }
    }
}
