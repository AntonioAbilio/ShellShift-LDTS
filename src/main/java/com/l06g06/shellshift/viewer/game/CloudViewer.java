package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Cloud;

public class CloudViewer implements ElementViewer<Cloud> {
    @Override
    public void draw(Cloud element, Gui gui) {
        gui.drawImageASCII(Components.Cloud.getImage(), element.getPosition());
    }
}
