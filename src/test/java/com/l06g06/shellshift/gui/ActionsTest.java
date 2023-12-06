/*
package com.l06g06.shellshift.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class ActionsTest {
    private TerminalScreen screen;
    private LanternaGUI gui;
    private TextGraphics graphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(TerminalScreen.class);
        graphics = Mockito.mock(TextGraphics.class);
        gui = new LanternaGUI(screen);

        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);
    }

    @Test
    void none() {
        try {
            Mockito.when(screen.readInput()).thenReturn(new KeyStroke('a',false,false));
            Gui.PressedKey key = gui.getNextAction();

            Assertions.assertEquals(Gui.PressedKey.NONE, key);
        } catch (IOException ioe) {
            fail("Caught the IOException: " + ioe.getMessage());
        }

    }

    @Test
    void up() {
        try {
            Mockito.when(screen.readInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));
            Gui.PressedKey key = gui.getNextAction();

            Assertions.assertEquals(Gui.PressedKey.UP, key);
        } catch (IOException ioe) {
            fail("Caught the IOException: " + ioe.getMessage());
        }

    }

    @Test
    void down() {
        try {
            Mockito.when(screen.readInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));
            Gui.PressedKey key = gui.getNextAction();

            Assertions.assertEquals(Gui.PressedKey.DOWN, key);
        } catch (IOException ioe) {
            fail("Caught the IOException: " + ioe.getMessage());
        }

    }

    @Test
    void left() {
        try {
            Mockito.when(screen.readInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));
            Gui.PressedKey key = gui.getNextAction();

            Assertions.assertEquals(Gui.PressedKey.LEFT, key);
        } catch (IOException ioe) {
            fail("Caught the IOException: " + ioe.getMessage());
        }

    }

    @Test
    void right() {
        try {
            Mockito.when(screen.readInput()).thenReturn(new KeyStroke(KeyType.ArrowRight));
            Gui.PressedKey key = gui.getNextAction();

            Assertions.assertEquals(Gui.PressedKey.RIGHT, key);
        } catch (IOException ioe) {
            fail("Caught the IOException: " + ioe.getMessage());
        }

    }

    @Test
    void fire() {
        try {
            Mockito.when(screen.readInput()).thenReturn(new KeyStroke(' ', false, false));
            Gui.PressedKey key = gui.getNextAction();

            Assertions.assertEquals(Gui.PressedKey.FIRE, key);
        } catch (IOException ioe) {
            fail("Caught the IOException: " + ioe.getMessage());
        }

    }

    @Test
    void select() {
        try {
            Mockito.when(screen.readInput()).thenReturn(new KeyStroke(KeyType.Enter));
            Gui.PressedKey key = gui.getNextAction();

            Assertions.assertEquals(Gui.PressedKey.SELECT, key);
        } catch (IOException ioe) {
            fail("Caught the IOException: " + ioe.getMessage());
        }

    }

    @Test
    void exit() {
        try {
            Mockito.when(screen.readInput()).thenReturn(new KeyStroke('q',false,false));
            Gui.PressedKey key = gui.getNextAction();

            Assertions.assertEquals(Gui.PressedKey.EXIT, key);
        } catch (IOException ioe) {
            fail("Caught the IOException: " + ioe.getMessage());
        }

    }
}
*/
