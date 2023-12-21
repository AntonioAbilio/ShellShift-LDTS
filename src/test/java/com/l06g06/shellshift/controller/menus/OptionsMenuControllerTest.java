package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;
import com.l06g06.shellshift.states.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class OptionsMenuControllerTest {

    private OptionsMenu optionsMenu;
    private OptionsMenuController optionsMenuController;
    private Game game;
    private Database database;

    @BeforeEach
    public void setup() {
        game = mock(Game.class);
        optionsMenu = mock(OptionsMenu.class);

        optionsMenuController = new OptionsMenuController(optionsMenu);

        Database.setInstance(this.database);
        database = Database.getInstance();
    }

    @Test
    public void testExit(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.EXIT);

        try {
            optionsMenuController.step(game, actions, 0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(game, times(1)).setState(Mockito.any(MainMenuState.class));
        verify(optionsMenu, never()).nextOption();
        verify(optionsMenu, never()).prevOption();
        verify(optionsMenu, never()).isSelectedSoundSlider();
        verify(optionsMenu, never()).isSoundOFF();
        verify(optionsMenu, never()).isSelectedONorOFF();
        verify(optionsMenu, never()).setSound(Mockito.anyBoolean());
        verify(optionsMenu, never()).setOptions(Mockito.anyList());
    }

    @Test
    public void testNextOption(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.DOWN);

        try {
            optionsMenuController.step(game, actions, 0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(optionsMenu, times(1)).nextOption();
        verify(optionsMenu, never()).prevOption();
        verify(optionsMenu, never()).isSelectedSoundSlider();
        verify(optionsMenu, never()).isSoundOFF();
        verify(optionsMenu, never()).isSelectedONorOFF();
        verify(optionsMenu, never()).setSound(Mockito.anyBoolean());
        verify(optionsMenu, never()).setOptions(Mockito.anyList());
    }

    @Test
    public void testSelectSoundONorOFF(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(optionsMenu.isSelectedONorOFF()).thenReturn(true);
        when(optionsMenu.isSoundOFF()).thenReturn(false);

        try {
            optionsMenuController.step(game, actions, 0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(optionsMenu, times(1)).setSound(true);
        verify(optionsMenu, times(1)).setOptions(Mockito.anyList());
        verify(optionsMenu, times(2)).isSoundOFF();

        verify(optionsMenu, never()).nextOption();
        verify(optionsMenu, never()).prevOption();
        verify(optionsMenu, never()).isSelectedSoundSlider();

    }

    @Test
    public void testSelectSoundSlider(){
        // TODO
    }
}
