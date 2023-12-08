package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.viewer.View;

public class CoinViewer implements ElementViewer<Coin> {


    @Override
    public void draw(Coin coin, Gui gui) {
        //View.ASCII_Drawer(COIN, coin.getPosition(),gui);
        gui.drawImageASCII(Components.Coin.getImage(), coin.getPosition());
    }

}
