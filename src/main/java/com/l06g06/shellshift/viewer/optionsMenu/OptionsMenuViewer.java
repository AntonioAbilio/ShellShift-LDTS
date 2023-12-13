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
        gui.drawImageASCII( getModel().isSoundOFF() ?  Components.SoundOFF.getImageSelected() : Components.SoundON.getImageSelected(), new Position(10,8));

    }
}
