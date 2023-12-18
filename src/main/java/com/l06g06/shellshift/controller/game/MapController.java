package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.*;
import com.l06g06.shellshift.controller.game.elements.enemies.EnemyController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.gui.ListenForKeys;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.states.GameOverState;

import java.io.IOException;
import java.util.List;

public class MapController extends GameController{
    private long addedScoreTimer = System.currentTimeMillis();
    private final ChellController chellController;
    private final BulletController bulletController;
    private final PlatformController platformController;
    private final CoinController coinController;
    private final EnemyController enemyController;
    private final CloudController cloudController;
    private final PowerUpController powerUpController;
    boolean checkpoint1 = false;
    boolean checkpoint2 = false;

    public MapController(Map map){
        super(map);
        this.chellController = new ChellController(map);
        this.bulletController = new BulletController(map);
        this.platformController = new PlatformController(map);
        this.coinController = new CoinController(map);
        this.enemyController = new EnemyController(map);
        this.cloudController = new CloudController(map);
        this.powerUpController = new PowerUpController(map);
        getModel().setGameStartTime(System.currentTimeMillis());
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        ListenForKeys.locked = true;
        enemyController.step(game, action, time);
        bulletController.step(game, action, time);
        chellController.step(game, action, time);
        platformController.step(game, action, time);
        coinController.step(game, action, time);
        cloudController.step(game, action, time);
        powerUpController.step(game, action, time);
        action.clear();
        ListenForKeys.locked = false;

        // adiciona 1 ponto a cada segundo
        if (System.currentTimeMillis() - addedScoreTimer >= 1000) {
            setAddedScoreTimer(System.currentTimeMillis());
            getModel().setScore(getModel().getScore() + 1);
        }

        // game over conditions, com out of bounds, border a direita esta no moveRIGHT()
        if (isGameOver()) {
            updateDatabase();
            getModel().stopCloudAddingTask();
            Game.sleepTimeMS(200);
            game.setState(new GameOverState(new GameOver()));
        }

        long elapsedTimeSinceGameStart =  (time - getModel().getGameStartTime()) / 1000;
        updateAcceleration(elapsedTimeSinceGameStart);

    }

    public void updateAcceleration(long elapsedTimeSinceGameStart){
        // Acceleration is divided in 3 levels
        if (!checkpoint1 && elapsedTimeSinceGameStart >= 5){
            checkpoint1 = true;
            getModel().setShiftCooldown(0.05);
            getModel().setSpawnCooldown(3);
        } else if (!checkpoint2 && elapsedTimeSinceGameStart >= 10){
            checkpoint2 = true;
            getModel().setShiftCooldown(0.03);
            getModel().setSpawnCooldown(2);
        }
    }

    public boolean isGameOver() {
        return getModel().getChell().getPosition().getY() > 150 || getModel().getChell().getPosition().getX() < 0 || getModel().getChell().getLives() <= 0;
    }

    public void updateDatabase() {
        Database.getInstance().addScore(getModel().getScore());
        Database.getInstance().addCoins(getModel().getCoinsCollected());
        Database.getInstance().addMonstersKilled(getModel().getMonstersKilled());
    }

    public void setAddedScoreTimer(long addedScoreTimer) {
        this.addedScoreTimer = addedScoreTimer;
    }

    public boolean isCheckpoint1() {
        return checkpoint1;
    }

    public boolean isCheckpoint2() {
        return checkpoint2;
    }

}
