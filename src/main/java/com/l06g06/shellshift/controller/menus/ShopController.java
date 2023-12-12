package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.Sound;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.gun.RapidFireStrategy;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.states.GameState;
import com.l06g06.shellshift.states.MainMenuState;
import com.l06g06.shellshift.states.ShopState;

import java.io.IOException;
import java.util.List;

public class ShopController extends Controller<Shop> {

    public ShopController(Shop shop) {
        super(shop);
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
                    Sound.playSound(Sound.SoundsFx.OptionSelect);
                    if (getModel().isSelectedQuit()) game.setState(new MainMenuState(new MainMenu()));
                    if (getModel().isSelectedRapidFire()) {
                        Database.getInstance().setFiringStrategy(new RapidFireStrategy());
                        game.setState(new MainMenuState(new MainMenu()));
                    }
                    if (getModel().isSelectedExtraLife()) {
                        Database.getInstance().setNumLives(Database.getInstance().getNumLives()+1);
                        game.setState(new MainMenuState(new MainMenu()));
                    }
                    break;
            }
            Game.sleepTimeMS(100);
        }

    }
}
