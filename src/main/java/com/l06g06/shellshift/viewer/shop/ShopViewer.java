package com.l06g06.shellshift.viewer.shop;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.viewer.View;

public class ShopViewer extends View<Shop> {

    public ShopViewer(Shop shop){
        super(shop);
    }

    @Override
    public void drawElements(Gui gui){
        gui.setGradientBackground("#2F1E0D", "#110902");
        gui.drawImageASCII(Components.Shop.getImage(), new Position(65, 5));

        int i = 0;
        for (Components text : getModel().getText()) {
            gui.drawImageASCII(getModel().isSelected(i) ? text.getImageSelected() : text.getImage(), new Position(12,25 + i * 15));
            i++;
        }
        i = 0;
        for (Components icon : getModel().getIcons()) {
            gui.drawImageASCII(icon.getImage(), new Position(100, 23 + i * 15));
            i++;
        }

    }
}
