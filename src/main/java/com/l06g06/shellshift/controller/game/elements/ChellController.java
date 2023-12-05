package com.l06g06.shellshift.controller.game.elements;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.map.Map;

import java.util.List;


public class ChellController extends GameController {

    public ChellController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {
        for (Gui.PressedKey gpk : action) {
            switch (gpk) {
                case UP:
                    getModel().getChell().moveUP();
                    break;
                case DOWN:
                    getModel().getChell().moveDOWN();
                    break;
                case LEFT:
                    getModel().getChell().moveLEFT();
                    break;
                case RIGHT:
                    getModel().getChell().moveRIGHT();
                    break;
            }
        }
    }
}
