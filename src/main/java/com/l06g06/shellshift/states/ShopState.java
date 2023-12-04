package com.l06g06.shellshift.states;

import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.ShopController;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.shop.ShopViewer;

public class ShopState extends State<Shop> {
    public ShopState(Shop model) {
        super(model);
    }

    @Override
    protected View<Shop> getViewer() {
        return new ShopViewer(getModel());
    }

    @Override
    protected Controller<Shop> getController() {
        return new ShopController(getModel());
    }
}
