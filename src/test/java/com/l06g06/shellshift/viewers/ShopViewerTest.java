package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.viewer.shop.ShopViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.junit.MockitoTestListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShopViewerTest {
    private Shop shop;
    private ShopViewer shopViewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        this.shop = Mockito.mock(Shop.class);
        this.shopViewer = new ShopViewer(shop);
        this.gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawShop() {
        List<Components> mockComponents = new ArrayList<>();
        mockComponents.add(Components.Shop);
        //when(shop.getText()).thenReturn(mockComponents);
        when(shop.getIcons()).thenReturn(mockComponents);

        shopViewer.drawElements(gui);
        verify(gui, Mockito.times(1)).setGradientBackground(Mockito.any(String.class), Mockito.any(String.class));
        verify(gui, Mockito.times(1)).drawImageASCII(eq(Components.Shop.getImage()), eq(new Position(10, 8)));
    }

}
