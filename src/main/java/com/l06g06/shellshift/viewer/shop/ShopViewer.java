package com.l06g06.shellshift.viewer.shop;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.viewer.View;

public class ShopViewer extends View<Shop> {

    public ShopViewer(Shop shop) {
        super(shop);
    }

    @Override
    public void drawElements(Gui gui) {
        gui.setGradientBackground("#ABF0F9", "#457da8");
        gui.drawImageASCII(Components.Shop.getImage(), new Position(10, 8));
        gui.drawImageASCII(Components.Coin.getImageSelected(), new Position(130, 6));
        gui.numToASCII(Database.getInstance().getNumCoins(), 138, 6);

        int i = 0;
        for (Components text : getModel().getOptions().keySet()) {
            gui.drawImageASCII(getModel().isSelected(i) ? text.getImageSelected() : text.getImage(), new Position(12, 30 + i * 15));
            gui.drawImageASCII(Components.Coin.getImageSelected(), new Position(127, 30 + i * 16));
            gui.numToASCII(getModel().getPrice(text), 135, 30 + i * 16);
            i++;
        }

        i = 0;
        for (Components icon : getModel().getIcons()) {
            gui.drawImageASCII(icon.getImage(), new Position(100, 28 + i * 15));
            i++;
        }

    }
}
