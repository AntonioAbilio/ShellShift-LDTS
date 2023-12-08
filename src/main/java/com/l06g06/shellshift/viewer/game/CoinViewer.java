package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.viewer.View;

public class CoinViewer implements ElementViewer<Coin> {


    /*private static final String[] HITBOX = new String[]{
            "P"
    };*/

    @Override
    public void draw(Coin coin, Gui gui) {
        //View.ASCII_Drawer(COIN, coin.getPosition(),gui);
        gui.drawImageASCII(Components.Coin.getImage(), coin.getPosition());

        //Uncomment this to see hithox.
        /*
        for (int i = 0; i < coin.getPolygon().npoints; i++) {
            int x = coin.getPolygon().xpoints[i];
            int y = coin.getPolygon().ypoints[i];
            View.ASCII_Drawer(HITBOX, new Position(x,y), gui);
            System.out.println("Vertex " + (i + 1) + ": (" + x + ", " + y + ")");
        }*/
    }

}
