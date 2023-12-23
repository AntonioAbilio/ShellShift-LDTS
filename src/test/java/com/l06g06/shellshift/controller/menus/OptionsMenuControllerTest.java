package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;
import com.l06g06.shellshift.states.MainMenuState;
import net.jqwik.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        database.setSound(true);
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
        verify(optionsMenu, never()).setSoundOFF(Mockito.anyBoolean());
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
        verify(optionsMenu, never()).setSoundOFF(Mockito.anyBoolean());
        verify(optionsMenu, never()).setOptions(Mockito.anyList());
    }

    @Test
    public void testPreviousOption(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.UP);

        try {
            optionsMenuController.step(game, actions, 0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(optionsMenu, times(1)).prevOption();
        verify(optionsMenu, never()).nextOption();
        verify(optionsMenu, never()).isSelectedSoundSlider();
        verify(optionsMenu, never()).isSoundOFF();
        verify(optionsMenu, never()).isSelectedONorOFF();
        verify(optionsMenu, never()).setSoundOFF(Mockito.anyBoolean());
        verify(optionsMenu, never()).setOptions(Mockito.anyList());
    }

    @Test
    public void testTurnON(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(optionsMenu.getOptions()).thenReturn(List.of(Components.SoundON, Components.SoundSliderButton));
        when(optionsMenu.isSelectedONorOFF()).thenReturn(true);
        when(optionsMenu.isSoundOFF()).thenReturn(false);

        List<Components> opts = List.of(Components.SoundON, Components.SoundSliderButton);

        try {
            optionsMenuController.step(game, actions, 0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(optionsMenu, times(1)).setSoundOFF(true);
        verify(optionsMenu, times(1)).setOptions(opts);
        verify(optionsMenu, times(2)).isSoundOFF();

        verify(optionsMenu, never()).nextOption();
        verify(optionsMenu, never()).prevOption();
        verify(optionsMenu, never()).isSelectedSoundSlider();
    }

    @Test
    public void testTurnOFF(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(optionsMenu.getOptions()).thenReturn(List.of(Components.SoundON, Components.SoundSliderButton));
        when(optionsMenu.isSelectedONorOFF()).thenReturn(true);
        when(optionsMenu.isSoundOFF()).thenReturn(true);

        List<Components> opts = List.of(Components.SoundON);

        try {
            optionsMenuController.step(game, actions, 0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        verify(optionsMenu, times(1)).setSoundOFF(false);
        verify(optionsMenu, times(1)).setOptions(opts);
        verify(optionsMenu, times(2)).isSoundOFF();

        verify(optionsMenu, never()).nextOption();
        verify(optionsMenu, never()).prevOption();
        verify(optionsMenu, never()).isSelectedSoundSlider();
    }

    @Provide
    Arbitrary<List<Gui.PressedKey>> actions() {
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.LEFT, Gui.PressedKey.RIGHT);
        return Arbitraries.of(List.of(actions));
    }

    @Property
    public void testSelectSoundSliderRight(@ForAll("actions") List<Gui.PressedKey> action) {
        // Your setup code here
        game = mock(Game.class);
        optionsMenu = mock(OptionsMenu.class);
        optionsMenuController = new OptionsMenuController(optionsMenu);
        Database.setInstance(this.database);
        database = Database.getInstance();

        when(optionsMenu.getOptions()).thenReturn(List.of(Components.SoundON, Components.SoundSliderButton));
        when(optionsMenu.isSelectedONorOFF()).thenReturn(false);
        when(optionsMenu.isSelectedSoundSlider()).thenReturn(true);
        when(optionsMenu.isSoundOFF()).thenReturn(false);

        Map<Gui.PressedKey, Integer> keyCounts = new HashMap<>();
        for (Gui.PressedKey key : action) {
            keyCounts.put(key, keyCounts.getOrDefault(key, 0) + 1);
        }

        int ogX = OptionsMenu.getSoundSliderX();
        float ogVol = OptionsMenu.getSoundSliderValue();

        int amountRight = 0;
        int amountLeft = 0;

        if (!(keyCounts.get(Gui.PressedKey.RIGHT) == null)){
            amountRight = keyCounts.get(Gui.PressedKey.RIGHT);
        }

        if (!(keyCounts.get(Gui.PressedKey.LEFT) == null)){
            amountLeft = keyCounts.get(Gui.PressedKey.LEFT);
        }

        int totalX =  amountRight - amountLeft;
        float totalVol = amountRight * 1.3F - (amountLeft * 1.3F);

        try {
            optionsMenuController.step(game, action, 0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        if (ogX + totalX >= 115){
            Assertions.assertEquals(115, OptionsMenu.getSoundSliderX());
            Assertions.assertEquals(-14F, OptionsMenu.getSoundSliderValue());
        } else if (ogX + totalX <= 78){
            Assertions.assertEquals(78, OptionsMenu.getSoundSliderX());
            Assertions.assertEquals(-60F, OptionsMenu.getSoundSliderValue());
        } else {
            Assertions.assertEquals(ogX + totalX, OptionsMenu.getSoundSliderX());
            Assertions.assertEquals(ogVol + totalVol, OptionsMenu.getSoundSliderValue());
        }

    }
}
