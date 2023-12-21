package com.l06g06.shellshift.model.optionsMenu;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OptionsMenuTest {

    private Database mockDatabase;
    private OptionsMenu optionsMenu;

    @BeforeEach
    void setUp() {
        mockDatabase = mock(Database.class);
        Database.setInstance(mockDatabase);
        when(mockDatabase.isSoundIsOn()).thenReturn(true);
        when(mockDatabase.getSoundSliderX()).thenReturn(78);
        when(mockDatabase.getSoundVolume()).thenReturn(-60F);

        optionsMenu = new OptionsMenu();
    }

    @Test
    public void isSoundONTest(){
        Assertions.assertTrue(!optionsMenu.isSoundOFF());
    }

    @Test
    public void isSelectedOnOrOff(){
        Assertions.assertTrue(optionsMenu.isSelected(0));
        Assertions.assertTrue(optionsMenu.isSelectedONorOFF());
        Assertions.assertTrue(optionsMenu.isSelected(optionsMenu.getCurrOption()));
        Assertions.assertFalse(optionsMenu.isSelectedSoundSlider());
    }

    @Test
    public void isSelectedSoundSlider(){
        optionsMenu.setSoundOFF(false);
        optionsMenu.setOptions(Arrays.asList(Components.SoundON, Components.SoundSliderButton));
        optionsMenu.nextOption();
        Assertions.assertTrue(optionsMenu.isSelectedSoundSlider());
        Assertions.assertTrue(optionsMenu.isSelected(1));
        Assertions.assertTrue(optionsMenu.isSelected(optionsMenu.getCurrOption()));
        Assertions.assertFalse(optionsMenu.isSelectedONorOFF());
    }

    @Test
    void OptionsOFF() {
        optionsMenu.setSoundOFF(true);
        optionsMenu.setOptions(List.of(Components.SoundON));
        List<Components> expectedOptions = List.of(Components.SoundON);
        assertEquals(expectedOptions, optionsMenu.getOptions());
    }

    @Test
    void OptionsON() {
        optionsMenu.setSoundOFF(false);
        optionsMenu.setOptions(Arrays.asList(Components.SoundON, Components.SoundSliderButton));
        List<Components> expectedOptions = Arrays.asList(Components.SoundON, Components.SoundSliderButton);
        assertEquals(expectedOptions, optionsMenu.getOptions());
    }

    @Test
    public void nextOptionTestSoundOff() {
        optionsMenu.setSoundOFF(true);
        optionsMenu.setOptions(List.of(Components.SoundON));
        optionsMenu.nextOption();
        assertEquals(0, optionsMenu.getCurrOption());
    }

    @Test
    public void prevOptionTestSoundOff() {
        optionsMenu.prevOption();
        assertEquals(0, optionsMenu.getCurrOption());
    }

    @Test
    public void nextOptionTestSoundON() {
        optionsMenu.setSoundOFF(false);
        optionsMenu.setOptions(Arrays.asList(Components.SoundON, Components.SoundSliderButton));
        optionsMenu.nextOption();
        assertEquals(1, optionsMenu.getCurrOption());
    }

    @Test
    public void prevOptionTestSoundON() {
        optionsMenu.setSoundOFF(false);
        optionsMenu.setOptions(Arrays.asList(Components.SoundON, Components.SoundSliderButton));
        optionsMenu.prevOption();
        assertEquals(0, optionsMenu.getCurrOption());
    }

    @Test
    void SoundStateAndDatabase() {
        OptionsMenu optionsMenu = new OptionsMenu();

        optionsMenu.setSoundOFF(false);

        assertFalse(optionsMenu.isSoundOFF());
        verify(mockDatabase).setSound(false);
    }

}
