package com.l06g06.shellshift.states;

import com.l06g06.shellshift.model.menus.ShopMenu;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.shop.ShopViewer;

public class ShopState extends State<ShopMenu>{
    public ShopState(ShopMenu model) {
        super(model);
    }

    @Override
    protected View<ShopMenu> getViewer() {
        return new ShopViewer(getModel());
    }
}
