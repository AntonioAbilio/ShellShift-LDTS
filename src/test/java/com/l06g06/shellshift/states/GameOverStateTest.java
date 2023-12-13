package com.l06g06.shellshift.states;

import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.GameOverController;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.model.gameOver.GameOverTests;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.gameOver.GameOverViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameOverStateTest {
    private GameOver gameOver;
    private GameOverState gameOverState;

    @BeforeEach
    void setup(){
        gameOver = Mockito.mock(GameOver.class);
        gameOverState = new GameOverState(gameOver);
    }

    @Test
    void getViewerTest(){
        View<GameOver> viewer = gameOverState.getViewer();

        Assertions.assertEquals(GameOverViewer.class, viewer.getClass());

    }

    @Test
    void getControllerTest(){
        Controller<GameOver> controller = gameOverState.getController();

        Assertions.assertEquals(GameOverController.class, controller.getClass());
    }
}
