package com.l06g06.shellshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComponentsTest {

    @Test
    public void testNumbers(){
        Assertions.assertEquals(10, Components.getNumbers().size());
    }

    @Test
    public void testNames(){
        Assertions.assertEquals("HealthBar", Components.valueOf(Components.class, "HealthBar").getName());
    }

    @Test
    void getOrdinalNumbersTest(){
        Assertions.assertEquals(Components.First, Components.getOrdinalNumbers().get(0));
    }
}
