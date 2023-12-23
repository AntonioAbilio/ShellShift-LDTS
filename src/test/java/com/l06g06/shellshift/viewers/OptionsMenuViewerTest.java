package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;
import com.l06g06.shellshift.viewer.optionsMenu.OptionsMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class OptionsMenuViewerTest {
    private OptionsMenu optionsMenu;
    private OptionsMenuViewer optionsMenuViewer;
    private Gui gui;

    @BeforeEach
    void setUp() {
        optionsMenu = Mockito.mock(OptionsMenu.class);
        when(optionsMenu.isSoundOFF()).thenReturn(false);
        when(optionsMenu.isSelectedONorOFF()).thenReturn(false);
        when(optionsMenu.isSelectedSoundSlider()).thenReturn(false);

        optionsMenuViewer = new OptionsMenuViewer(optionsMenu);
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawElementsWhenSoundIsON() {
        when(optionsMenu.isSoundOFF()).thenReturn(false);

        optionsMenuViewer.drawElements(gui);

        verify(gui, times(1)).setGradientBackground(any(String.class), any(String.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundON.getImage()), any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.SoundOFF.getImage()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.Platform.getImageSelected()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundSliderButton.getImage()), any(Position.class));
    }

    @Test
    void drawElementsWhenSoundIsOFF() {
        when(optionsMenu.isSoundOFF()).thenReturn(true);

        optionsMenuViewer.drawElements(gui);

        verify(gui, times(1)).setGradientBackground(any(String.class), any(String.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.SoundON.getImage()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundOFF.getImage()), any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.Platform.getImageSelected()), any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.SoundSliderButton.getImage()), any(Position.class));
    }

    @Test
    void drawElementsWhenSliderIsSelected() {
        when(optionsMenu.isSelectedSoundSlider()).thenReturn(true);

        optionsMenuViewer.drawElements(gui);

        verify(gui, times(1)).setGradientBackground(any(String.class), any(String.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundON.getImage()), any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.SoundON.getImageSelected()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.Platform.getImageSelected()), any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.SoundSliderButton.getImage()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundSliderButton.getImageSelected()), any(Position.class));
    }

    @Test
    void drawElementsWhenSoundOnIsSelected() {
        when(optionsMenu.isSelectedONorOFF()).thenReturn(true);

        optionsMenuViewer.drawElements(gui);

        verify(gui, times(1)).setGradientBackground(any(String.class), any(String.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.SoundON.getImage()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundON.getImageSelected()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.Platform.getImageSelected()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundSliderButton.getImage()), any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.SoundSliderButton.getImageSelected()), any(Position.class));
    }

    @Test
    void testAbstractView() throws IOException {
        optionsMenuViewer.draw(gui);

        verify(gui, times(1)).clear();
        verify(gui,times(1)).refresh();
        verify(gui, times(1)).drawImageASCII(eq(Components.SoundON.getImage()), any(Position.class));
    }
}

