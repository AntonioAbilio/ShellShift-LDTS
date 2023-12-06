package com.l06g06.shellshift.controller.menus;


import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.states.GameState;
import com.l06g06.shellshift.states.ShopState;
import com.l06g06.shellshift.states.ShopState;

import java.io.IOException;
import java.util.List;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        for (Gui.PressedKey gpk : action) {
            switch (gpk) {
                case UP:
                    getModel().prevOption();
                    break;
                case DOWN:
                    getModel().nextOption();
                    break;
                case SELECT:
                    if (getModel().isSelectedQuit()) game.setState(null);
                    if (getModel().isSelectedShop()) game.setState(new ShopState(new Shop()));
                    if (getModel().isSelectedStart()) game.setState(new GameState(new Map(50, 50)));
                    break;
            }
        }
    }
}
