package com.l06g06.shellshift;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharColorTest {

    @Test
    void getChar_ReturnsCorrectChar() {
        CharColor charColor = CharColor.Orange;
        assertEquals('*', charColor.getChar());
    }

    @Test
    void Color() {
        CharColor charColor = CharColor.Orange;
        assertEquals("#ED7C2B", charColor.getColor());
    }

    @Test
    void UnknownCharCharColor() {
        char inputChar = 'H';
        CharColor charColor = CharColor.getCharColor(inputChar);
        assertEquals(CharColor.Black, charColor);
        assertNotNull(charColor);
    }

    @Test
    void KnownCharCharColor() {
        char inputChar = 'A';
        CharColor charColor = CharColor.getCharColor(inputChar);
        assertEquals(CharColor.DarkBrown, charColor);
    }
}
