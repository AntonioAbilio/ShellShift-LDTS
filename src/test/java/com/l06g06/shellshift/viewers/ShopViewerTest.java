package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.viewer.shop.ShopViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class ShopViewerTest {
    private Shop shop;
    private ShopViewer viewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        shop = Mockito.mock(Shop.class);
        viewer = new ShopViewer(shop);
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawShop() {

        try {
            viewer.drawTest(gui);
            Mockito.verify(gui, Mockito.times(1)).drawText(Mockito.any(Position.class), Mockito.eq("Shop"), Mockito.eq("#FFFFF"));
        } catch (IOException ioe) {
            fail("Caught the IOException: " + ioe.getMessage());
        }

    }
}
