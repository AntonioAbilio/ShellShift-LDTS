package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.viewer.game.CoinViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.eq;

public class CoinViewerTest {
    private Coin coin;
    private CoinViewer coinViewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        coin = new Coin(new Position(10,10));
        coinViewer = new CoinViewer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawCoinTest(){
        coinViewer.draw(coin, gui);
        Mockito.verify(gui, Mockito.times(1)).drawImageASCII(eq(Components.Coin.getImage()), eq(coin.getPosition()));
    }
}
