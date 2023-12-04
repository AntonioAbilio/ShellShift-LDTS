package com.l06g06.shellshift.viewer.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.viewer.CharColor;

//public class CoinViewer implements ElementViewer<Coin>{
public class CoinViewer extends NewElementViewer { // Temporary Change
    private Coin coin;  // Corresponding Model

    public CoinViewer(Coin coin, TextGraphics graphics){
        super(graphics);
        this.coin = coin;
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


    @Override
    public void draw(){
        int x_pos = coin.getPosition().getX();
        int y_pos = coin.getPosition().getY();
        String[] drawing = COIN;
        //int x_mid = drawing[0].length()/2;
        //int y_mid = drawing.length/2;

        for(int y = 0; y < drawing.length; y++){
            for(int x = 0; x < drawing[0].length(); x++){
                char c = drawing[y].charAt(x);
                if(c!=' '){
                    setColor(c);
                    graphics.fillRectangle(new TerminalPosition(x_pos + x, y_pos + y),
                            new TerminalSize(5, 5), ' ');
                }
            }
        }

    }

    public void setColor(char color_char){
        CharColor c = CharColor.getCharColor(color_char);
        //if (c!=null)
           // setBackgroundColor(c);
    }


/*    @Override
    public void draw(Coin coin, Gui gui){
    }*/
}
