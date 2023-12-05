package com.l06g06.shellshift.controller.game.elements.enemies;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.map.Map;

import java.util.List;


public class EnemyController extends GameController {
    public EnemyController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {
        //ToDo
    }
}
