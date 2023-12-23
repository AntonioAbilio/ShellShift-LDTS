package com.l06g06.shellshift;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CharColorTest {

    @Test
    void getChar_ReturnsCorrectChar() {
        Database.getInstance().setSound(true);
        CharColor charColor = CharColor.Orange;
        assertEquals('*', charColor.getChar());
    }

    @Test
    void Color() {
        Database.getInstance().setSound(true);
        CharColor charColor = CharColor.Orange;
        assertEquals("#ED7C2B", charColor.getColor());
    }

    @Test
    void UnknownCharCharColor() {
        Database.getInstance().setSound(true);
        char inputChar = 'H';
        CharColor charColor = CharColor.getCharColor(inputChar);
        assertEquals(CharColor.Black, charColor);
        assertNotNull(charColor);
    }

    @Test
    void KnownCharCharColor() {
        Database.getInstance().setSound(true);
        char inputChar = 'A';
        CharColor charColor = CharColor.getCharColor(inputChar);
        assertEquals(CharColor.DarkBrown, charColor);
    }
}
