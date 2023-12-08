package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.viewer.View;

public class CoinViewer implements ElementViewer<Coin> {

    public static final String[] COIN={
        "   JJJJ   ",
        "  JGGGGJ  ",
        " JGRRRRQJ ",
        " JGRGGRQJ ",
        "JGRGRRJRQJ",
        "JGRGRRJRQJ",
        "JGRGRRJRQJ",
        "JGRGRRJRQJ",
        "JGRGRRJRQJ",
        "JGRGRRJRQJ",
        "JGRGRRJRQJ",
        " JRRJJRQJ ",
        " JRRRRRQJ ",
        "  JQQQQJ  ",
        "   JJJJ   ",
    };

    @Override
    public void draw(Coin coin, Gui gui) {
        //View.ASCII_Drawer(COIN, coin.getPosition(),gui);
        gui.drawImageASCII(COIN, coin.getPosition());
    }

}
