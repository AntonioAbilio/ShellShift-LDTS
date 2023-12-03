package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin>{

    /*private Coin coin;  // Corresponding Model

    public static final String[] COIN={
        " AA ",
        "AAAA",
        "AAAA",
        "AAAA",
        "AAAA",
        "AAAA",
        " AA "
    };*/

    @Override
    public void draw(Coin coin, Gui gui){
        gui.drawCoin(coin.getPosition());
    }
}
