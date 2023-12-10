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
        bullet.setDamageMultiplier(20);
        Assertions.assertEquals(20, bullet.getDamageMultiplier());
    }
}
