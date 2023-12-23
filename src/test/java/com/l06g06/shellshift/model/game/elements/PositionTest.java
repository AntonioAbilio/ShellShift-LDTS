package com.l06g06.shellshift.model.game.elements;

import com.l06g06.shellshift.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

public class PositionTest {
    private Position position;

    @BeforeEach
    void setup(){
        Database.getInstance().setSound(true);
        this.position = new Position(16, 7);
    }

    @Test
    @SuppressWarnings({"SelfEquals", "EqualsIncompatibleType"})
    public void equalsTest(){
        position = null;
        Position position2 = new Position(2, 5);
        if (position2.equals(position)) fail();
        if (!position2.equals(position2)) fail();
        Coin coin = new Coin(new Position(0, 0));
        position = new Position(16, 7);
        if (position.equals(coin)) fail();
        position2 = new Position(16, 7);
        Position position3 = new Position(100,1000);
        if (!position.equals(position2)) fail();
        if (position2.equals(position3)) fail();
    }

    @Test
    void hashCodeTest() {
        Position position1 = new Position(5, 10);
        Position position2 = new Position(5, 10);
        Position position3 = new Position(100,1000);
        int rand = (int) Instant.now().getEpochSecond();
        int expectedHashCode = (Objects.hash(5, 10) + rand) % 1333;
        Assertions.assertTrue(position1.hashCode() >= 0 && position1.hashCode() < 1333);
        Assertions.assertTrue(position2.hashCode() >= 0 && position2.hashCode() < 1333);
        Assertions.assertEquals(expectedHashCode, position1.hashCode());
        Assertions.assertEquals(position1.hashCode(), position2.hashCode());
        Assertions.assertFalse(position3.hashCode() < 0);
        Assertions.assertFalse(position3.hashCode() >= 1333);
        Assertions.assertNotEquals(expectedHashCode, position3.hashCode());
        Assertions.assertNotEquals(position1.hashCode(), position3.hashCode());
        Assertions.assertNotEquals(position2.hashCode(), position3.hashCode());
    }

}
