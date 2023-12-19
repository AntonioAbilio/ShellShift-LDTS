package com.l06g06.shellshift.model.game.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {
    private Position position;

    @BeforeEach
    void setup(){
        this.position = new Position(16, 7);
    }

    @Test
    public void equalsTest(){
        position = null;
        Position position2 = new Position(2, 5);
        Assertions.assertFalse(position2.equals(position));

        Coin coin = new Coin(new Position(0, 0));
        Assertions.assertFalse(position2.equals(coin));

        position = new Position(16, 7);
        position2 = new Position(16, 7);
        Assertions.assertTrue(position2.equals(position));
    }

}
