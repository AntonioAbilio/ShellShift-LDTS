package com.l06g06.shellshift.viewer.optionsMenu;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;
import com.l06g06.shellshift.viewer.View;

public class OptionsMenuViewer extends View<OptionsMenu> {
    public OptionsMenuViewer(OptionsMenu model) {
        super(model);
    }

    @Override
    public void drawElements(Gui gui) {
        gui.setGradientBackground("#ABF0F9", "#457da8");
        gui.drawImageASCII(getModel().isSoundOFF() ? (getModel().isSelectedONorOFF() ? Components.SoundOFF.getImageSelected() : Components.SoundOFF.getImage()) : (getModel().isSelectedONorOFF() ? Components.SoundON.getImageSelected() : Components.SoundON.getImage()), new Position(10, 8));
        if (!getModel().isSoundOFF()) {
            gui.drawImageASCII(Components.Platform.getImageSelected(), new Position(80, 10));
            gui.drawImageASCII(getModel().isSelectedSoundSlider() ? Components.SoundSliderButton.getImageSelected() : Components.SoundSliderButton.getImage(), new Position(OptionsMenu.getSoundSliderX(), 8)); // 115, 8
        }
    }
}
