package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.Sound;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.gun.RapidFireStrategy;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.states.MainMenuState;

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
                        int price = getModel().getPrice(Components.RapidFire);
                        if (price <= Database.getInstance().getNumCoins()) {
                            Database.getInstance().setFiringStrategy(new RapidFireStrategy());
                            Database.getInstance().setNumCoins(Database.getInstance().getNumCoins() - price);
                            game.setState(new MainMenuState(new MainMenu()));
                        }
                    }
                    if (getModel().isSelectedExtraLife()) {
                        int price = getModel().getPrice(Components.ExtraLife);
                        if (price <= Database.getInstance().getNumCoins() && Database.getInstance().getNumLives() < 8) {
                            Database.getInstance().setNumLives(Database.getInstance().getNumLives()+1);
                            Database.getInstance().setNumCoins(Database.getInstance().getNumCoins()- price);
                            game.setState(new MainMenuState(new MainMenu()));

                        }
                    }
                    if (getModel().isSelectedMoreBullets()) {
                        int price = getModel().getPrice(Components.MoreBullets);
                        Database.getInstance().addStartingBullets(10);
                        Database.getInstance().setNumCoins(Database.getInstance().getNumCoins()- price);
                        game.setState(new MainMenuState(new MainMenu()));
                    }
                    break;
            }

            Game.sleepTimeMS(100);
        }

    }
}
