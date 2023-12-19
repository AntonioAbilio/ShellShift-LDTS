package com.l06g06.shellshift.model.game.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class BulletTest {

    private Bullet bullet;
    private Position position;

    @BeforeEach
    void setup(){
        this.position = mock(Position.class);
        this.bullet = new Bullet(position);
    }

    @Test
    void setGetDamageMultiplierTest(){
        bullet.setDamageMultiplier(10);
        Assertions.assertEquals(10, bullet.getDamageMultiplier());
        Assertions.assertEquals(500, bullet.getDamage());
    }

    @Test
    void hitboxTest(){
        bullet.setPosition(new Position(0, 0));
        Assertions.assertEquals(0, bullet.getPolygon().xpoints[0]);
        Assertions.assertEquals(3, bullet.getPolygon().xpoints[1]);
        Assertions.assertEquals(0, bullet.getPolygon().xpoints[2]);
        Assertions.assertEquals(3, bullet.getPolygon().xpoints[3]);

        Assertions.assertEquals(0, bullet.getPolygon().ypoints[0]);
        Assertions.assertEquals(0, bullet.getPolygon().ypoints[1]);
        Assertions.assertEquals(3, bullet.getPolygon().ypoints[2]);
        Assertions.assertEquals(3, bullet.getPolygon().ypoints[3]);
    }
}
