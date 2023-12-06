package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.states.MainMenuState;
import com.l06g06.shellshift.states.ShopState;

import java.io.IOException;
import java.util.List;

public class ShopController extends Controller<Shop> {

    public ShopController(Shop shop) {
        super(shop);
    }

    @Override
    public void step(Game game, Gui.PressedKey action, long time) throws IOException {
       /* switch (action) {
            case UP:
                getModel().prevOption();
                break;
            case DOWN:
                getModel().nextOption();
                break;
            case SELECT:
                if (getModel().isSelectedQuit()) game.setState(new MainMenuState(new MainMenu()));
        }*/
    }
}
