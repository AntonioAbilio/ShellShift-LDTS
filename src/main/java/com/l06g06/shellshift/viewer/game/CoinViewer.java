package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin> {

    @Override
    public void draw(Coin coin, Gui gui) {
        gui.drawImageASCII(Components.Coin.getImage(), coin.getPosition());
    }

}
