package com.l06g06.shellshift.model.game.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlatformTest {

    @Test
    void widthHeightGetTest(){
        Assertions.assertEquals(4, Platform.getHeight());
        Assertions.assertEquals(66, Platform.getWidth());
    }

}
