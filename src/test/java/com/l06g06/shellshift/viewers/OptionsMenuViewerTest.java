package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;
import com.l06g06.shellshift.viewer.optionsMenu.OptionsMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class OptionsMenuViewerTest {
    private OptionsMenu optionsMenu;
    private OptionsMenuViewer optionsMenuViewer;
    private Gui gui;

    @BeforeEach
    void setUp() {
        optionsMenu = Mockito.mock(OptionsMenu.class);
        when(optionsMenu.isSoundOFF()).thenReturn(false); // set necessary parameters
        when(optionsMenu.isSelectedONorOFF()).thenReturn(false); // set necessary parameters
        when(optionsMenu.isSelectedSoundSlider()).thenReturn(false); // set necessary parameters

        optionsMenuViewer = new OptionsMenuViewer(optionsMenu);
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawElementsWhenSoundIsON() {
        when(optionsMenu.isSoundOFF()).thenReturn(false);
        when(optionsMenu.isSelectedONorOFF()).thenReturn(true);
        when(optionsMenu.isSelectedSoundSlider()).thenReturn(false);

        optionsMenuViewer.drawElements(gui);

        verify(gui, times(1)).setGradientBackground("#ABF0F9", "#457da8");
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundON.getImage()), any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.SoundON.getImageSelected()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.Platform.getImageSelected()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundSliderButton.getImageSelected()), any(Position.class));
    }

    @Test
    void drawElementsWhenSoundIsOFF() {
        when(optionsMenu.isSoundOFF()).thenReturn(true);
        when(optionsMenu.isSelectedONorOFF()).thenReturn(false);
        when(optionsMenu.isSelectedSoundSlider()).thenReturn(false);

        optionsMenuViewer.drawElements(gui);

        verify(gui, times(1)).setGradientBackground("#ABF0F9", "#457da8");
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundOFF.getImage()), any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.SoundOFF.getImageSelected()), any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.Platform.getImageSelected()), any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.SoundSliderButton.getImageSelected()), any(Position.class));
    }

    @Test
    void drawElementsWhenSliderIsSelected() {
        when(optionsMenu.isSoundOFF()).thenReturn(false);
        when(optionsMenu.isSelectedONorOFF()).thenReturn(false);
        when(optionsMenu.isSelectedSoundSlider()).thenReturn(true);

        optionsMenuViewer.drawElements(gui);

        verify(gui, times(1)).setGradientBackground("#ABF0F9", "#457da8");
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundON.getImage()), any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.SoundON.getImageSelected()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.Platform.getImageSelected()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundSliderButton.getImageSelected()), any(Position.class));
    }
}

