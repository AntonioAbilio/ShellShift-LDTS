package com.l06g06.shellshift.viewer.shop;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.menus.ShopMenu;
import com.l06g06.shellshift.viewer.View;

public class ShopViewer extends View<ShopMenu> {

    public ShopViewer(ShopMenu shop){
        super(shop);
    }

    @Override
    public void drawElements(Gui gui){
        gui.drawText(new Position(10,10), "Shop", "#FFFFF");

        // Still need to figure out elements to add to shop ...
    }
}
