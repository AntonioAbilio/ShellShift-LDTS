/*
package com.l06g06.shellshift.gui;

import com.google.common.collect.ImmutableList;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.l06g06.shellshift.model.game.elements.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class LanternaGUITest {
    private TerminalScreen screen;
    private LanternaGUI gui;
    private TextGraphics graphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(TerminalScreen.class);
        graphics = Mockito.mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(graphics);

        gui = new LanternaGUI(screen);
    }

    @Test
    void testLanternaGUIConstructor() throws IOException {
        int width = 1;
        int height = 1;

        try {
            gui = new LanternaGUI(width, height);
            assertNotNull(gui.getScreen());
            Assertions.assertEquals(width, gui.getScreen().getTerminalSize().getColumns());
            Assertions.assertEquals(height + 1, gui.getScreen().getTerminalSize().getRows());
        } catch (IOException | URISyntaxException | FontFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testGetNextAction() {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        LanternaGUI gui = new LanternaGUI(screen);

        gui.addButton(38); // UP
        gui.addButton(40); // DOWN
        gui.addButton(37); // LEFT
        gui.addButton(39); // RIGHT
        gui.addButton(10); // SELECT
        gui.addButton(32); // FIRE
        gui.addButton(27); // EXIT

        List<Gui.PressedKey> pressedKeys = gui.getNextAction();

        assertEquals(7, pressedKeys.size());
        assertTrue(pressedKeys.contains(Gui.PressedKey.UP));
        assertTrue(pressedKeys.contains(Gui.PressedKey.DOWN));
        assertTrue(pressedKeys.contains(Gui.PressedKey.LEFT));
        assertTrue(pressedKeys.contains(Gui.PressedKey.RIGHT));
        assertTrue(pressedKeys.contains(Gui.PressedKey.SELECT));
        assertTrue(pressedKeys.contains(Gui.PressedKey.FIRE));
        assertTrue(pressedKeys.contains(Gui.PressedKey.EXIT));
    }

    @Test
    void testDrawImageASCII() {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(textGraphics);

        LanternaGUI gui = new LanternaGUI(screen);
        Position position = new Position(0, 0);
        ImmutableList<String> image = ImmutableList.of("***", "yyy", "<");

        gui.drawImageASCII(image, position);

        verify(textGraphics, times(7)).putString(anyInt(), anyInt(), anyString());
        verify(textGraphics, times(7)).setBackgroundColor(any());
        verify(textGraphics, times(1)).putString(0,0, " ");
    }

    @SuppressWarnings("DirectInvocationOnMock")
    @Test
    void testSetBackground() {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(textGraphics);
        when(screen.getTerminalSize()).thenReturn(new TerminalSize(160,100));


        LanternaGUI gui = new LanternaGUI(screen);
        gui.setBackground("#FFFFFF");

        verify(textGraphics).setBackgroundColor(any());
        verify(textGraphics).setForegroundColor(any());
        verify(textGraphics, times(screen.getTerminalSize().getRows())).putString(anyInt(), anyInt(), anyString());
    }

    @SuppressWarnings("DirectInvocationOnMock")
    @Test
    void testSetGradientBackground() {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(textGraphics);
        when(screen.getTerminalSize()).thenReturn(new TerminalSize(160, 100));

        LanternaGUI gui = new LanternaGUI(screen);
        gui.setGradientBackground("#ABF0F9", "#457da8");

        verify(textGraphics, times(screen.getTerminalSize().getRows() * screen.getTerminalSize().getColumns())).setBackgroundColor(any());
        verify(textGraphics, times(screen.getTerminalSize().getRows() * screen.getTerminalSize().getColumns())).setForegroundColor(any());
        verify(textGraphics, times(screen.getTerminalSize().getRows() * screen.getTerminalSize().getColumns())).putString(anyInt(), anyInt(), anyString());
    }

    @Test
    void testClear() {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        LanternaGUI gui = new LanternaGUI(screen);

        gui.clear();

        verify(screen).clear();
    }

    @Test
    void testRefresh() throws IOException {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        LanternaGUI gui = new LanternaGUI(screen);

        gui.refresh();

        verify(screen).refresh();
    }

    @Test
    void testClose() throws IOException {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        LanternaGUI gui = new LanternaGUI(screen);

        gui.close();

        verify(screen).close();
    }


}*/
