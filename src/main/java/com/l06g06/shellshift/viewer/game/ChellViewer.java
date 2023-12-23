package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Position;


public class ChellViewer implements ElementViewer<Chell> {
    @Override
    public void draw(Chell chell, Gui gui) {
        if (!chell.getBlink())
            gui.drawImageASCII(chell.isDirection() ? Components.Chell.getImage() : Components.Chell.getImageSelected(), new Position(chell.getPosition().getX() - 14, chell.getPosition().getY() - 14));
    }
}