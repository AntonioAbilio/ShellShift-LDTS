package com.l06g06.shellshift.controller.game.elements;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.map.Map;

import java.util.List;


public class BulletController extends GameController {
    public BulletController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {
        //ToDo
    }
}
