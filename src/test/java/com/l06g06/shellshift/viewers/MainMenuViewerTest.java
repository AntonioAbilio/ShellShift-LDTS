package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.viewer.mainMenu.MainMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.junit.MockitoTestListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainMenuViewerTest {
    private MainMenu mainMenu;
    private MainMenuViewer mainMenuViewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        mainMenu = Mockito.mock(MainMenu.class);
        mainMenuViewer = new MainMenuViewer(mainMenu);
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawMainMenu() {
        List<Components> mockComponents = new ArrayList<>();
        mockComponents.add(Components.Start);
        when(mainMenu.getOptions()).thenReturn(mockComponents);

        mainMenuViewer.drawElements(gui);
        verify(gui, Mockito.times(1)).setGradientBackground(Mockito.any(String.class), Mockito.any(String.class));
        verify(gui, Mockito.times(1)).drawImageASCII(eq(Components.Title.getImage()), Mockito.any(Position.class));
        verify(gui, Mockito.times(1)).drawImageASCII(eq(Components.Chell.getImage()), Mockito.any(Position.class));
    }
}
