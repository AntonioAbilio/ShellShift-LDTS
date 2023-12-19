package com.l06g06.shellshift.model.game.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class CoinTest {

    private Coin coin;
    private Position position;

    @BeforeEach
    void setup(){
        this.position = mock(Position.class);
        this.coin = new Coin(position);
    }

    @Test
    public void hitboxTest(){
        coin.setPosition(new Position(0, 0));
        Assertions.assertEquals(1, coin.getPolygon().xpoints[0]);
        Assertions.assertEquals(9, coin.getPolygon().xpoints[1]);
        Assertions.assertEquals(1, coin.getPolygon().xpoints[2]);
        Assertions.assertEquals(9, coin.getPolygon().xpoints[3]);

        Assertions.assertEquals(1, coin.getPolygon().ypoints[0]);
        Assertions.assertEquals(1, coin.getPolygon().ypoints[1]);
        Assertions.assertEquals(14, coin.getPolygon().ypoints[2]);
        Assertions.assertEquals(14, coin.getPolygon().ypoints[3]);
    }

    @Test
    public void getValue(){
        Assertions.assertEquals(10, coin.getValue());
    }

}
