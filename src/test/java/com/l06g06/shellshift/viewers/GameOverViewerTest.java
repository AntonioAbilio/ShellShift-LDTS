package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.viewer.gameOver.GameOverViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class GameOverViewerTest {
    private GameOver gameOver;
    private GameOverViewer gameOverViewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        gameOver = Mockito.mock(GameOver.class);
        gameOverViewer = new GameOverViewer(gameOver);
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawGameOver() {
        List<Components> mockComponents = new ArrayList<>();
        mockComponents.add(Components.GameOver);

        gameOverViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawImageASCII(eq(Components.GameOver.getImage()), eq(new Position(25, 10)));
    }

}
