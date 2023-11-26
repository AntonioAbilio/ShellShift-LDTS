package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.viewer.gameOver.GameOverViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class GameOverViewerTest {
    private GameOver gameover;
    private GameOverViewer viewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        gameover = Mockito.mock(GameOver.class);
        viewer = new GameOverViewer(gameover);
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawGameOver() {

        try {
            viewer.drawTest(gui);
            Mockito.verify(gui, Mockito.times(1)).drawText(Mockito.any(Position.class), Mockito.eq("GameOver!"), Mockito.eq("#FFFFF"));
        } catch (IOException ioe) {
            fail("Caught the IOException: " + ioe.getMessage());
        }

    }
}
