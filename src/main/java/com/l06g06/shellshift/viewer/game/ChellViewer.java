package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;

public class ChellViewer implements ElementViewer<Chell>{
    @Override
    public void draw(Chell chell, Gui gui){
        gui.drawChell(chell.getPosition());
    }
}
