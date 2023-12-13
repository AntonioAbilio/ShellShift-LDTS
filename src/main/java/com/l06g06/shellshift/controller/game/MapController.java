package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.*;
import com.l06g06.shellshift.controller.game.elements.enemies.EnemyController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.states.GameOverState;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MapController extends GameController{
    private long addedScoreTimer = System.currentTimeMillis();
    private final ChellController chellController;
    private final BulletController bulletController;
    private final GunController gunController;
    private final PlatformController platformController;
    private final CoinController coinController;
    private final EnemyController enemyController;
    static long gameStartTime;
    static double shiftCooldown = 0.1;
    static int spawnCooldown = 5;

    boolean updated1 = false;
    boolean updated2 = false;

    private final CloudController cloudController;

    private final PowerUpController powerUpController;
    public MapController(Map map){
        super(map);
        this.chellController = new ChellController(map);
        this.bulletController = new BulletController(map);
        this.gunController = new GunController(map);
        this.platformController = new PlatformController(map);
        this.coinController = new CoinController(map);
        this.enemyController = new EnemyController(map);
        this.cloudController = new CloudController(map);
        this.powerUpController = new PowerUpController(map);
        gameStartTime = System.currentTimeMillis();
    }

    private void enemyCollisionHandler(Game game, long time) {
        // Check for Chell and Enemy collisions. -> por esta funcao dentro da chell
        if (ElementEnemyCollision(getModel().getChell())) {
            getModel().getChell().decreaseLives();
            getModel().getChell().activateBlink();
        }
    }
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        enemyController.step(game, action, time);
        bulletController.step(game, action, time);
        chellController.step(game, action, time);
        gunController.step(game, action, time);
        platformController.step(game, action, time);
        coinController.step(game, action, time);
        cloudController.step(game, action, time);
        powerUpController.step(game, action, time);

        enemyCollisionHandler(game, time);


        // adiciona 1 ponto a cada segundo
        if (System.currentTimeMillis() - addedScoreTimer >= 1000) {
            setAddedScoreTimer(System.currentTimeMillis());
            getModel().setScore(getModel().getScore() + 1);
        }

        // game over conditions, com out of bounds, border a direita esta no moveRIGHT()
        if (getModel().getChell().getPosition().getY() > 150 | getModel().getChell().getPosition().getX() < 0 | getModel().getChell().getLives() <= 0) {
            Database.getInstance().addScore(getModel().getScore());
            Database.getInstance().addCoins(getModel().getCoinsCollected());
            Database.getInstance().addMonstersKilled(getModel().getMonstersKilled());
            getModel().stopCloudAddingTask();
            Game.sleepTimeMS(200);
            game.setState((new GameOverState(new GameOver())));
        }

        long elapsedTimeSinceGameStart =  (time - MapController.getGameStartTime()) / 1000;

        updateAcceleration(elapsedTimeSinceGameStart);


    }

    public void updateAcceleration(long elapsedTimeSinceGameStart){
        // Acceleration is divided in 3 levels
        if (!updated1 && elapsedTimeSinceGameStart >= 5){
            updated1 = true;
            shiftCooldown = 0.06;
            System.out.println("30 seconds passed (Acceleration level 2)");
        } else if (!updated2 && elapsedTimeSinceGameStart >= 10){
            updated2 = true;
            shiftCooldown = 0.03;
            spawnCooldown = 2;
            System.out.println("120 seconds passed (Acceleration level 3)");
        }
    }

    public void setAddedScoreTimer(long addedScoreTimer) {
        this.addedScoreTimer = addedScoreTimer;
    }

    public static long getGameStartTime(){
        return gameStartTime;
    }

    public static double getShiftCooldown(){
        return shiftCooldown;
    }
    public static int getSpawnCooldown() {
        return spawnCooldown;
    }
}
