package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.menus.MainMenuController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.states.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
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
        verify(mainMenu, times(1)).isSelectedStatistics();
        verify(mainMenu, times(1)).isSelectedTutorial();
        verify(mainMenu, times(1)).isSelectedOptions();
        verify(mainMenu, times(1)).isSelectedQuit();
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

    @Test
    public void selectStartTest() {
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(mainMenu.isSelectedStart()).thenReturn(true);
        when(mainMenu.isSelectedShop()).thenReturn(false);
        when(mainMenu.isSelectedTutorial()).thenReturn(false);
        when(mainMenu.isSelectedStatistics()).thenReturn(false);
        when(mainMenu.isSelectedOptions()).thenReturn(false);
        when(mainMenu.isSelectedQuit()).thenReturn(false);

        try {
            mainMenuController.step(game, actions, 100);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(mainMenu, times(1)).isSelectedStart();
        verify(game, times(1)).setState(Mockito.any(GameState.class));
        verify(mainMenu, times(1)).isSelectedShop();
        verify(game, never()).setState(Mockito.any(ShopState.class));
        verify(mainMenu, times(1)).isSelectedStatistics();
        verify(game, never()).setState(Mockito.any(StatisticsState.class));
        verify(mainMenu, times(1)).isSelectedTutorial();
        verify(game, never()).setState(Mockito.any(TutorialState.class));
        verify(mainMenu, times(1)).isSelectedOptions();
        verify(game, never()).setState(Mockito.any(OptionsMenuState.class));
        verify(mainMenu, times(1)).isSelectedQuit();
        verify(game, never()).setState(null);
    }

    @Test
    public void selectShopTest(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(mainMenu.isSelectedStart()).thenReturn(false);
        when(mainMenu.isSelectedShop()).thenReturn(true);
        when(mainMenu.isSelectedTutorial()).thenReturn(false);
        when(mainMenu.isSelectedStatistics()).thenReturn(false);
        when(mainMenu.isSelectedOptions()).thenReturn(false);
        when(mainMenu.isSelectedQuit()).thenReturn(false);

        try {
            mainMenuController.step(game, actions, 100);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(mainMenu, times(1)).isSelectedStart();
        verify(game, never()).setState(Mockito.any(GameState.class));
        verify(mainMenu, times(1)).isSelectedShop();
        verify(game, times(1)).setState(Mockito.any(ShopState.class));
        verify(mainMenu, times(1)).isSelectedStatistics();
        verify(game, never()).setState(Mockito.any(StatisticsState.class));
        verify(mainMenu, times(1)).isSelectedTutorial();
        verify(game, never()).setState(Mockito.any(TutorialState.class));
        verify(mainMenu, times(1)).isSelectedOptions();
        verify(game, never()).setState(Mockito.any(OptionsMenuState.class));
        verify(mainMenu, times(1)).isSelectedQuit();
        verify(game, never()).setState(null);
    }

    @Test
    public void selectTutorialTest(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(mainMenu.isSelectedStart()).thenReturn(false);
        when(mainMenu.isSelectedShop()).thenReturn(false);
        when(mainMenu.isSelectedTutorial()).thenReturn(true);
        when(mainMenu.isSelectedStatistics()).thenReturn(false);
        when(mainMenu.isSelectedOptions()).thenReturn(false);
        when(mainMenu.isSelectedQuit()).thenReturn(false);

        try {
            mainMenuController.step(game, actions, 100);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(mainMenu, times(1)).isSelectedStart();
        verify(game, never()).setState(Mockito.any(GameState.class));
        verify(mainMenu, times(1)).isSelectedShop();
        verify(game, never()).setState(Mockito.any(ShopState.class));
        verify(mainMenu, times(1)).isSelectedStatistics();
        verify(game, never()).setState(Mockito.any(StatisticsState.class));
        verify(mainMenu, times(1)).isSelectedTutorial();
        verify(game, times(1)).setState(Mockito.any(TutorialState.class));
        verify(mainMenu, times(1)).isSelectedOptions();
        verify(game, never()).setState(Mockito.any(OptionsMenuState.class));
        verify(mainMenu, times(1)).isSelectedQuit();
        verify(game, never()).setState(null);
    }

    @Test
    public void selectStatisticsTest(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(mainMenu.isSelectedStart()).thenReturn(false);
        when(mainMenu.isSelectedShop()).thenReturn(false);
        when(mainMenu.isSelectedTutorial()).thenReturn(false);
        when(mainMenu.isSelectedStatistics()).thenReturn(true);
        when(mainMenu.isSelectedOptions()).thenReturn(false);
        when(mainMenu.isSelectedQuit()).thenReturn(false);

        try {
            mainMenuController.step(game, actions, 100);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(mainMenu, times(1)).isSelectedStart();
        verify(game, never()).setState(Mockito.any(GameState.class));
        verify(mainMenu, times(1)).isSelectedShop();
        verify(game, never()).setState(Mockito.any(ShopState.class));
        verify(mainMenu, times(1)).isSelectedStatistics();
        verify(game, times(1)).setState(Mockito.any(StatisticsState.class));
        verify(mainMenu, times(1)).isSelectedTutorial();
        verify(game, never()).setState(Mockito.any(TutorialState.class));
        verify(mainMenu, times(1)).isSelectedOptions();
        verify(game, never()).setState(Mockito.any(OptionsMenuState.class));
        verify(mainMenu, times(1)).isSelectedQuit();
        verify(game, never()).setState(null);
    }

    @Test
    public void selectOptionsTest(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(mainMenu.isSelectedStart()).thenReturn(false);
        when(mainMenu.isSelectedShop()).thenReturn(false);
        when(mainMenu.isSelectedTutorial()).thenReturn(false);
        when(mainMenu.isSelectedStatistics()).thenReturn(false);
        when(mainMenu.isSelectedOptions()).thenReturn(true);
        when(mainMenu.isSelectedQuit()).thenReturn(false);

        try {
            mainMenuController.step(game, actions, 100);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(mainMenu, times(1)).isSelectedStart();
        verify(game, never()).setState(Mockito.any(GameState.class));
        verify(mainMenu, times(1)).isSelectedShop();
        verify(game, never()).setState(Mockito.any(ShopState.class));
        verify(mainMenu, times(1)).isSelectedStatistics();
        verify(game, never()).setState(Mockito.any(StatisticsState.class));
        verify(mainMenu, times(1)).isSelectedTutorial();
        verify(game, never()).setState(Mockito.any(TutorialState.class));
        verify(mainMenu, times(1)).isSelectedOptions();
        verify(game, times(1)).setState(Mockito.any(OptionsMenuState.class));
        verify(mainMenu, times(1)).isSelectedQuit();
        verify(game, never()).setState(null);
    }

    @Test
    public void selectQuitTest(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(mainMenu.isSelectedStart()).thenReturn(false);
        when(mainMenu.isSelectedShop()).thenReturn(false);
        when(mainMenu.isSelectedTutorial()).thenReturn(false);
        when(mainMenu.isSelectedStatistics()).thenReturn(false);
        when(mainMenu.isSelectedOptions()).thenReturn(false);
        when(mainMenu.isSelectedQuit()).thenReturn(true);

        try {
            mainMenuController.step(game, actions, 100);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(mainMenu, times(1)).isSelectedStart();
        verify(mainMenu, times(1)).isSelectedShop();
        verify(mainMenu, times(1)).isSelectedStatistics();
        verify(mainMenu, times(1)).isSelectedTutorial();
        verify(mainMenu, times(1)).isSelectedOptions();
        verify(game, never()).setState(notNull());
        verify(mainMenu, times(1)).isSelectedQuit();
        verify(game).setState(null);

    }
}
