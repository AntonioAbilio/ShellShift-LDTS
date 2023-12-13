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

}
