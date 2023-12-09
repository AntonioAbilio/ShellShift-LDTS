package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.model.tutorial.Tutorial;
import com.l06g06.shellshift.states.GameState;
import com.l06g06.shellshift.states.MainMenuState;
import com.l06g06.shellshift.states.ShopState;
import com.l06g06.shellshift.states.TutorialState;

import java.io.IOException;
import java.util.List;

public class TutorialController extends Controller<Tutorial> {
    public TutorialController(Tutorial model) {
        super(model);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        for (Gui.PressedKey gpk : action) {
            switch (gpk) {
                case UP:
                    getModel().setSelectedArrowUp(true);
                    break;
                case LEFT:
                    getModel().setSelectedArrowLeft(true);
                    break;
                case RIGHT:
                    getModel().setSelectedArrowRight(true);
                    break;
                case FIRE:
                    getModel().setSelectedSpace(true);
                    break;
                case SELECT:
                    game.setState(new MainMenuState(new MainMenu()));
                   break;
            }
        }
    }
}
