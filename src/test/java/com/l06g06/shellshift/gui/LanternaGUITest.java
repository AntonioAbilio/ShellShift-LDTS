package com.l06g06.shellshift.gui;

import com.google.common.collect.ImmutableList;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class LanternaGUITest {
    private TerminalScreen screen;
    private LanternaGUI gui;

    @BeforeEach
    void setUp() {
        Database.getInstance().setSound(true);
        screen = Mockito.mock(TerminalScreen.class);
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(graphics);
        gui = new LanternaGUI(screen);
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

    @Test
    public void testNumToASCII() {
        LanternaGUI guiSpy = spy(gui);
        guiSpy.numToASCII(1, 0, 0);
        verify(guiSpy, times(1)).drawImageASCII(eq(ImmutableList.of(
                " GG ",
                "G G",
                "  G",
                "  G",
                "GGGG"
        )), any(Position.class));
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
        gui.clear();
        verify(screen).clear();
    }

    @Test
    void testRefresh() throws IOException {
        gui.refresh();
        verify(screen).refresh();
    }

    @Test
    void keyListenerTest(){
        gui = mock(LanternaGUI.class);
        class MockKeyListener implements KeyListener{

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                gui.addButton(1);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gui.removeButton(1);
            }
        }
        MockKeyListener mockKeyListener = new MockKeyListener();
        gui.addKeyListener(mockKeyListener);
        verify(gui).addKeyListener(mockKeyListener);
    }
}
