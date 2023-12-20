package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.menus.MainMenuController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class MainMenuControllerTest {
    private MainMenuController mainMenuController;
    private MainMenu mainMenu;
    private Game game;

    @BeforeEach
    public void setUp() {
        mainMenu = mock(MainMenu.class);
        mainMenuController = new MainMenuController(mainMenu);
        game = mock(Game.class);
    }

    @Test
    public void stepSelectTest() throws IOException {
        List<Gui.PressedKey> actions = Arrays.asList(Gui.PressedKey.SELECT);
        mainMenuController.step(game, actions, 100);
        verify(mainMenu, times(1)).isSelectedStart();
        verify(mainMenu, times(1)).isSelectedShop();
        verify(mainMenu, times(1)).isSelectedQuit();

        // ToDo: Uncomment when Statistics and Tutorial are implemented
        //verify(mainMenu, times(1)).isSelectedStatistics();
        //verify(mainMenu, times(1)).isSelectedTutorial();
    }

    @Test
    public void stepUpTest() throws IOException {
        List<Gui.PressedKey> actions = Arrays.asList(Gui.PressedKey.UP);
        mainMenuController.step(game, actions, 100);
        verify(mainMenu, times(1)).prevOption();
        verify(mainMenu, times(0)).nextOption();
    }

    @Test
    public void stepDownTest() throws IOException {
        List<Gui.PressedKey> actions = Arrays.asList(Gui.PressedKey.DOWN);
        mainMenuController.step(game, actions, 100);
        verify(mainMenu, times(1)).nextOption();
        verify(mainMenu, times(0)).prevOption();
    }
}
