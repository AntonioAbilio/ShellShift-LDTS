package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.*;
import com.l06g06.shellshift.controller.game.elements.enemies.EnemyController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.states.GameOverState;

import java.io.IOException;
import java.util.Iterator;
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

    private void enemyColisionHandler(Game game){
        // Check for Chell and Enemy collisions.

        if (ElementEnemyCollision(getModel().getChell())){
            System.out.println("AUCH!");
            int lives = getModel().getChell().getLives();
            if (lives <= 0)
                game.setState(new GameOverState(new GameOver()));
            else
                getModel().getChell().setLives(lives - 1);
        }

        // Check for Bullet and Enemy collisions.
        List<Bullet> bullets = getModel().getBullets();
        Iterator<Bullet> bulletIterator = bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            if (ElementEnemyCollision(bullet)) bulletIterator.remove();
        }

    }

    private void outOfBoundsHandler(Game game){
        if (getModel().getChell().getPosition().getY() >= this.getModel().getHeight()+15){
            System.out.println("ChellPos: " + getModel().getChell().getPosition().getY());

            System.out.println("Ground: " + (this.getModel().getHeight()+15));
            System.out.println("out");
                game.setState(new GameOverState(new GameOver()));
        }
    }

    // Step should give the received action to each controller...
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        enemyController.step(game, action, time);
        bulletController.step(game, action, time);
        chellController.step(game, action, time);

        enemyColisionHandler(game);
        outOfBoundsHandler(game);

        gunController.step(game, action, time);
        platformController.step(game, action, time);
        coinController.step(game, action, time);

        if (getModel().getGun().getNumBullets() <= 0) {
            game.setState(new GameOverState(new GameOver()));
        }
        // ToDo
    }

}
