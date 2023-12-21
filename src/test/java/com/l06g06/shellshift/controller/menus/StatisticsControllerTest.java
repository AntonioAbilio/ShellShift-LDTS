package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.model.statistics.Statistics;
import com.l06g06.shellshift.states.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class StatisticsControllerTest {

    private StatisticsController statisticsController;
    private Game game;
    private Statistics statistics;

    @BeforeEach
    public void setUp(){
        game = mock(Game.class);
        statistics = mock(Statistics.class);

        statisticsController = new StatisticsController(statistics);
    }

    @Test
    public void ExitTest() {
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.EXIT);

        try {
            statisticsController.step(game, actions, 100);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(game, never()).setState(Mockito.any(GameState.class));
        verify(game, never()).setState(Mockito.any(ShopState.class));
        verify(game, never()).setState(Mockito.any(StatisticsState.class));
        verify(game, never()).setState(Mockito.any(TutorialState.class));
        verify(game, never()).setState(Mockito.any(OptionsMenuState.class));
        verify(game, never()).setState(null);

        verify(game, times(1)).setState(Mockito.any(MainMenuState.class));
    }
}
