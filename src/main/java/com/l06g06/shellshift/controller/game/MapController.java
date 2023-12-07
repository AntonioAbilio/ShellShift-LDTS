package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.BulletController;
import com.l06g06.shellshift.controller.game.elements.ChellController;
import com.l06g06.shellshift.controller.game.elements.GunController;
import com.l06g06.shellshift.controller.game.elements.enemies.EnemyController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.states.GameOverState;

import java.io.IOException;
import java.util.List;

public class MapController extends GameController{

    private final ChellController chellController;
    private final EnemyController enemyController;
    private final BulletController bulletController;
    private final GunController gunController;

    public MapController(Map map){
        super(map);
        this.chellController = new ChellController(map);
        this.enemyController = new EnemyController(map);
        this.bulletController = new BulletController(map);
        this.gunController = new GunController(map);
        //ToDo (more are missing)
    }

    // Step should give the recived action to each controller...
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        enemyController.step(game, action, time);
        bulletController.step(game, action, time);
        chellController.step(game, action, time);
        gunController.step(game, action, time);

        if (getModel().getGun().getNumBullets() <= 0) {
            game.setState(new GameOverState(new GameOver()));
        }
        // ToDo
    }

}
