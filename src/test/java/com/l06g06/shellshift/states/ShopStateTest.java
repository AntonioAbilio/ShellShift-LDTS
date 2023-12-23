package com.l06g06.shellshift.states;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.ShopController;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.shop.ShopViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShopStateTest {
    private Shop shop;
    private ShopState shopState;

    @BeforeEach
    void setup(){
        Database.getInstance().setSound(true);
        shop = Mockito.mock(Shop.class);
        shopState = new ShopState(shop);
    }

    @Test
    void getViewerTest(){
        View<Shop> viewer = shopState.getViewer();

        Assertions.assertEquals(ShopViewer.class, viewer.getClass());

    }

    @Test
    void getControllerTest(){
        Controller<Shop> controller = shopState.getController();

        Assertions.assertEquals(ShopController.class, controller.getClass());
    }
}
