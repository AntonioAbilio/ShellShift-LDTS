package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.*;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;
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
                case EXIT:
                    game.setState(new MainMenuState(new MainMenu()));
                    break;
                case UP:
                    getModel().prevOption();
                    break;
                case DOWN:
                    getModel().nextOption();
                    break;
                case SELECT:
                    //SomAqui Sound.playSound(SoundsFx.OptionSelect);
                    Sound sound = Sound.getInstance();
                    sound.playSound(SoundsFx.OptionSelect);
                    if (getModel().isSelectedRapidFire()) {
                        int price = getModel().getPrice(Components.RapidFire);

                        if (price <= Database.getInstance().getNumCoins() && Database.getInstance().getFiringStrategy() instanceof NormalFireStrategy) {
                            Database.getInstance().setFiringStrategy(new RapidFireStrategy());
                            Database.getInstance().setNumCoins(Database.getInstance().getNumCoins() - price);
                            game.setState(new MainMenuState(new MainMenu()));
                        }
                    }
                    if (getModel().isSelectedExtraLife()) {
                        int price = getModel().getPrice(Components.ExtraLife);
                        if (price <= Database.getInstance().getNumCoins() && Database.getInstance().getNumLives() < Database.getInstance().getMAXLIVES()) {
                            Database.getInstance().setNumLives(Database.getInstance().getNumLives() + 1);
                            Database.getInstance().setNumCoins(Database.getInstance().getNumCoins() - price);
                            game.setState(new MainMenuState(new MainMenu()));

                        }
                    }
                    if (getModel().isSelectedMoreBullets()) {
                        int price = getModel().getPrice(Components.MoreBullets);
                        if (price <= Database.getInstance().getNumCoins() && Database.getInstance().getStartingNumBullets() < Database.getInstance().getMAXBULLETS()) {
                            Database.getInstance().addStartingBullets(10);
                            Database.getInstance().setNumCoins(Database.getInstance().getNumCoins() - price);
                            game.setState(new MainMenuState(new MainMenu()));
                        }
                    }
                    break;
                default:
            }

            Game.sleepTimeMS(100);
        }

    }
}
