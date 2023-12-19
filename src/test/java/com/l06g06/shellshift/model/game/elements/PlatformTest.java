package com.l06g06.shellshift.model.game.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class PlatformTest {

    private Platform platform;
    private Position position;

    @BeforeEach
    void setup(){
        this.position = mock(Position.class);
        this.platform = new Platform(position);
    }

    @Test
    void widthHeightGetTest(){
        Assertions.assertEquals(4, Platform.getHeight());
        Assertions.assertEquals(66, Platform.getWidth());
    }

    @Test
    public void hitboxTest(){
        platform.setPosition(new Position(0, 0));
        Assertions.assertEquals(0, platform.getPolygon().xpoints[0]);
        Assertions.assertEquals(-66, platform.getPolygon().xpoints[1]);
        Assertions.assertEquals(0, platform.getPolygon().xpoints[2]);
        Assertions.assertEquals(-66, platform.getPolygon().xpoints[3]);

        Assertions.assertEquals(0, platform.getPolygon().ypoints[0]);
        Assertions.assertEquals(0, platform.getPolygon().ypoints[1]);
        Assertions.assertEquals(3, platform.getPolygon().ypoints[2]);
        Assertions.assertEquals(3, platform.getPolygon().ypoints[3]);
    }

}
