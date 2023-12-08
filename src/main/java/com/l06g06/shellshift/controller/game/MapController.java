package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.*;
import com.l06g06.shellshift.controller.game.elements.enemies.EnemyController;
import com.l06g06.shellshift.controller.game.elements.enemies.HardMonsterController;
import com.l06g06.shellshift.controller.game.elements.enemies.SoftMonsterController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.creators.PlatformCreator;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.states.GameOverState;
import com.l06g06.shellshift.states.MainMenuState;
import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.List;

public class MapController extends GameController{

    private final ChellController chellController;
    private final BulletController bulletController;
    private final GunController gunController;
    private final PlatformController platformController;
    private final CoinController coinController;
    //private final SoftMonsterController softMonsterController;
    //private final HardMonsterController hardMonsterController;
    private final EnemyController enemyController;

    public MapController(Map map){
        super(map);
        this.chellController = new ChellController(map);
        this.bulletController = new BulletController(map);
        this.gunController = new GunController(map);
        this.platformController = new PlatformController(map);
        this.coinController = new CoinController(map);
        //this.softMonsterController = new SoftMonsterController(map);
        //this.hardMonsterController = new HardMonsterController(map);
        this.enemyController = new EnemyController(map);
        //ToDo (more are missing)
    }

    // Step should give the received action to each controller...
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        enemyController.step(game, action, time);
        bulletController.step(game, action, time);
        chellController.step(game, action, time);
        gunController.step(game, action, time);
        platformController.step(game, action, time);
        coinController.step(game, action, time);

        /*
        if (getModel().getGun().getNumBullets() <= 0) {
            game.setState(new GameOverState(new GameOver()));
        }
         */

        if (getModel().getChell().getLives() <= 0) {
            Game.sleepTimeMS(1000);
            game.setState((new GameOverState(new GameOver())));
        }
    }

}
