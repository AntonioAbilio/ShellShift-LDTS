package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.viewer.gameOver.GameOverViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


public class GameOverViewerTest {
    private GameOver gameOver;
    private GameOverViewer gameOverViewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        Database.getInstance().setSound(true);
        gameOver = Mockito.mock(GameOver.class);

        List<Components> mockOptions = Arrays.asList(Components.Restart, Components.MainMenu);
        when(gameOver.getOptions()).thenReturn(mockOptions);

        gameOverViewer = new GameOverViewer(gameOver);
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawGameOver() {
        gameOverViewer.drawElements(gui);
        verify(gui, times(1)).drawImageASCII(eq(Components.GameOver.getImage()), any(Position.class));
    }

    @Test
    @SuppressWarnings("DirectInvocationOnMock")
    void drawSelectedOptions() {
        when(gameOver.isSelected(anyInt())).thenReturn(true);
        gameOverViewer.drawElements(gui);
        for (Components c : gameOver.getOptions()) {
            verify(gui, times(1)).drawImageASCII(eq(c.getImageSelected()), any(Position.class));
        }
    }

    @Test
    @SuppressWarnings("DirectInvocationOnMock")
    void drawUnselectedOptions() {
        when(gameOver.isSelected(anyInt())).thenReturn(true);
        gameOverViewer.drawElements(gui);
        verify(gui, times(1)).drawImageASCII(eq(gameOver.getOptions().get(0).getImageSelected()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(gameOver.getOptions().get(1).getImageSelected()), any(Position.class));
    }

    @Test
    void testYIncrement() {
        gameOverViewer.drawElements(gui);
        verify(gui, times(1)).drawImageASCII(eq(Components.Restart.getImage()),eq(new Position(15, 45)));
        verify(gui, times(1)).drawImageASCII(eq(Components.MainMenu.getImage()),eq(new Position(15, 57)));
    }

}
