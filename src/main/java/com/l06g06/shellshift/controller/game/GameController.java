package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.model.game.map.Map;


public abstract class GameController extends Controller<Map> {
    public GameController(Map map) {
        super(map);
    }
}
