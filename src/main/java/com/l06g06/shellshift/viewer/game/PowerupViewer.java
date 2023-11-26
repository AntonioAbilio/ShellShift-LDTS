package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.PowerUp;

public class PowerupViewer implements ElementViewer<PowerUp>{

    @Override
    public void draw(PowerUp element, Gui gui) {
        gui.drawPowerup(element.getPosition());
    }
}
