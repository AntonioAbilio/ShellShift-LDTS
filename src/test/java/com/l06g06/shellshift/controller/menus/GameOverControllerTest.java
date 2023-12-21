package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.states.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class GameOverControllerTest {

    private GameOver gameOver;
    private GameOverController gameOverController;
    private Game game;

    @BeforeEach
    public void setup(){
        game = mock(Game.class);
        gameOver = mock(GameOver.class);

        gameOverController = new GameOverController(gameOver);
    }

    @Test
    public void stepSelectTest(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);
        try {
            gameOverController.step(game, actions, 0);
            verify(gameOver, times(1)).isSelectedRestart();
            verify(gameOver, times(1)).isSelectedMainMenu();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    public void stepUpTest(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.UP);
        try {
            gameOverController.step(game, actions, 0);
            verify(gameOver, times(1)).prevOption();
            verify(gameOver, times(0)).nextOption();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    public void stepDownTest(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.DOWN);
        try {
            gameOverController.step(game, actions, 0);
            verify(gameOver, times(0)).prevOption();
            verify(gameOver, times(1)).nextOption();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    public void selectMainMenuTest() {
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(gameOver.isSelectedMainMenu()).thenReturn(true);
        when(gameOver.isSelectedRestart()).thenReturn(false);

        try {
            gameOverController.step(game, actions, 100);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(gameOver, times(1)).isSelectedMainMenu();
        verify(game, times(1)).setState(Mockito.any(MainMenuState.class));

        verify(gameOver, times(1)).isSelectedRestart();
        verify(game, never()).setState(Mockito.any(GameState.class));

        verify(game, never()).setState(Mockito.any(ShopState.class));
        verify(game, never()).setState(Mockito.any(StatisticsState.class));
        verify(game, never()).setState(Mockito.any(TutorialState.class));
        verify(game, never()).setState(Mockito.any(OptionsMenuState.class));
        verify(game, never()).setState(null);
    }

    @Test
    public void selectRestartTest() {
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(gameOver.isSelectedMainMenu()).thenReturn(false);
        when(gameOver.isSelectedRestart()).thenReturn(true);

        try {
            gameOverController.step(game, actions, 100);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(gameOver, times(1)).isSelectedRestart();
        verify(game, times(1)).setState(Mockito.any(GameState.class));

        verify(gameOver, times(1)).isSelectedMainMenu();
        verify(game, never()).setState(Mockito.any(MainMenuState.class));

        verify(game, never()).setState(Mockito.any(ShopState.class));
        verify(game, never()).setState(Mockito.any(StatisticsState.class));
        verify(game, never()).setState(Mockito.any(TutorialState.class));
        verify(game, never()).setState(Mockito.any(OptionsMenuState.class));
        verify(game, never()).setState(null);
    }

}
