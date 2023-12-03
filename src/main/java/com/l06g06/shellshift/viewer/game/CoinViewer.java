package com.l06g06.shellshift.viewer.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.viewer.NewView;

//public class CoinViewer implements ElementViewer<Coin>{
public class CoinViewer extends NewView { // Temporary Change
    private Coin coin;  // Corresponding Model

    /*public CoinViewer(Coin coin, TextGraphics graphics, Screen screen){
        super(graphics, screen);
        this.coin = coin;
    }*/

    public CoinViewer(){

    }


    public static final String[] COIN={
        " AA ",
        "AAAA",
        "AAAA",
        "AAAA",
        "AAAA",
        "AAAA",
        " AA "
    };


    /*@Override
    public void draw(Coin coin, Gui gui){
        gui.drawCoin(coin.getPosition());
    }*/


/*    @Override
    public void draw(Coin coin, Gui gui){
    }*/
}
