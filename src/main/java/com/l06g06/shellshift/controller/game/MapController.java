package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.ChellController;
import com.l06g06.shellshift.controller.game.elements.enemies.EnemyController;

import java.io.IOException;
import java.util.Map;

public class MapController extends GameController{

    private final ChellController chellController;
    private final EnemyController enemyController;

    public MapController(Map map){
        super(map);

        this.chellController = new ChellController(map);
        this.enemyController = new EnemyController(map);
        //ToDo (more are missing)
    }

    /*public void step(Game game, GUI.ACTION action, long time) throws IOException {
        // ToDo
    }*/

}
