package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.viewer.mainMenu.MainMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class MainMenuViewerTest {
    private MainMenu mainMenu;
    private MainMenuViewer mainMenuViewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        Database.getInstance().setSound(true);
        mainMenu = Mockito.mock(MainMenu.class);
        mainMenuViewer = new MainMenuViewer(mainMenu);
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawMainMenu() {
        mainMenuViewer.drawElements(gui);

        verify(gui, Mockito.times(1)).setGradientBackground(Mockito.any(String.class), Mockito.any(String.class));
        verify(gui, Mockito.times(1)).drawImageASCII(eq(Components.Title.getImage()), Mockito.any(Position.class));
        verify(gui, Mockito.times(1)).drawImageASCII(eq(Components.Chell.getImage()), Mockito.any(Position.class));
        verify(gui, times(2)).drawImageASCII(eq(Components.Cloud.getImage()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.Platform.getImageSelected()), any(Position.class));

    }

    @Test
    void drawOptionsUnselected() {
        List<Components> mockComponents = new ArrayList<>();
        mockComponents.add(Components.Start);
        mockComponents.add(Components.Statistics);

        when(mainMenu.getOptions()).thenReturn(mockComponents);
        when(mainMenu.isSelected(anyInt())).thenReturn(false);

        mainMenuViewer.drawElements(gui);

        for (Components c : mainMenu.getOptions()) {
            verify(gui, times(1)).drawImageASCII(eq(c.getImage()), any(Position.class));
        }
    }

    @Test
    void drawOptionsSelected() {
        List<Components> mockComponents = new ArrayList<>();
        mockComponents.add(Components.Start);
        mockComponents.add(Components.Statistics);

        when(mainMenu.getOptions()).thenReturn(mockComponents);
        when(mainMenu.isSelected(anyInt())).thenReturn(true);

        mainMenuViewer.drawElements(gui);

        for (Components c : mainMenu.getOptions()) {
            verify(gui, times(1)).drawImageASCII(eq(c.getImageSelected()), any(Position.class));
        }
    }

    @Test
    void testYIncrement() {
        List<Components> mockComponents = new ArrayList<>();
        mockComponents.add(Components.Start);
        mockComponents.add(Components.Statistics);
        when(mainMenu.getOptions()).thenReturn(mockComponents);
        when(mainMenu.isSelected(anyInt())).thenReturn(false);


        mainMenuViewer.drawElements(gui);

        verify(gui, times(1)).drawImageASCII(eq(Components.Start.getImage()), eq(new Position(15,28)));
        verify(gui, times(1)).drawImageASCII(eq(Components.Statistics.getImage()), eq(new Position(15,40)));
    }
}
