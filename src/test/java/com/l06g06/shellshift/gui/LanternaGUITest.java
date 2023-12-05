package com.l06g06.shellshift.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;
import com.l06g06.shellshift.model.game.elements.Position;
import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class LanternaGUITest {
    private TerminalScreen screen;
    private LanternaGUI gui;
    private TextGraphics graphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(TerminalScreen.class);
        graphics = Mockito.mock(TextGraphics.class);

        // If screen.newTextGraphics() is called then mockito should return graphics.
        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);

        // Create an instance of the gui using the screen that mockito created.
        gui = new LanternaGUI(screen);
    }


    @Test
    void drawChell() {
        // Draw Chell.
        gui.drawChell(new Position(1, 2));

        // Check:
        // Chell's color.
        // Check if she is in the right position and if the right character was used.
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "P");
    }

    @Test
    void drawCoin() {
        gui.drawCoin(new Position(1, 2));

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "c");
    }

    @Test
    void drawBullet() {
        gui.drawBullet(new Position(1, 2));

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "*");
    }

    @Test
    void drawPlatform() {
        gui.drawPlatform(new Position(1, 2));

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "-");
    }

    @Test
    void drawMonster() {
        gui.drawMonster(new Position(1, 2));

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "M");
    }

    @Test
    void drawText() {
        //Draw some text on the screen
        gui.drawText(new Position(1, 1), "Tutorial", "#FFFF00");

        // Check the position and color of the drawn text.
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 1, "Tutorial");
    }

    @Test
    void drawPowerup() {
        gui.drawPowerup(new Position(1, 2));

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(graphics, Mockito.times(1)).putString(1, 2, "=");
    }
}
