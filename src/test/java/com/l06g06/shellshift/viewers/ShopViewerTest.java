package com.l06g06.shellshift.viewers;
import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.viewer.shop.ShopViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

public class ShopViewerTest {
    private ShopViewer shopViewer;
    private Shop shop;
    private Gui gui;
    @BeforeEach
    void setUp() {
        // Initialize mock objects
        shop = mock(Shop.class);
        gui = mock(Gui.class);

        // Set up mock behavior for Shop
        Map<Components, Integer> options = new HashMap<>();
        options.put(Components.RapidFire, 50);
        options.put(Components.ExtraLife, 20);
        options.put(Components.MoreBullets, 10);
        when(shop.getOptions()).thenReturn(options);

        List<Components> icons = Arrays.asList(Components.RapidFireIcon, Components.HeartIcon, Components.MoreBulletsIcon);
        when(shop.getIcons()).thenReturn(icons);

        // Initialize ShopViewer after setting up mocks
        shopViewer = new ShopViewer(shop);
    }

    @Test
    void drawShopElements() {
        shopViewer.drawElements(gui);
        verify(gui, times(1)).setGradientBackground(any(String.class), any(String.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.Shop.getImage()), any(Position.class));

        verify(gui, times(shop.getOptions().size() + 1)).drawImageASCII(eq(Components.Coin.getImageSelected()), any(Position.class));
        verify(gui, times(shop.getOptions().size() + 1)).numToASCII(anyInt(), anyInt(), anyInt());

        for (Components c : shop.getOptions().keySet()) {
            verify(gui, times(1)).drawImageASCII(eq(c.getImage()), any(Position.class));
        }

        for (Components c : shop.getIcons()) {
            verify(gui, times(1)).drawImageASCII(eq(c.getImage()), any(Position.class));
        }

    }

    @Test
    void drawElementsSelected() {
        when(shop.isSelected(anyInt())).thenReturn(true);
        shopViewer.drawElements(gui);

        for (Components c : shop.getOptions().keySet()) {
            verify(gui, times(1)).drawImageASCII(eq(c.getImageSelected()), any(Position.class));
        }
    }

}

