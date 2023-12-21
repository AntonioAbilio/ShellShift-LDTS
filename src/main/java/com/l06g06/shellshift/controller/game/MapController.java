package com.l06g06.shellshift.controller.game;

import com.google.common.annotations.VisibleForTesting;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.*;
import com.l06g06.shellshift.controller.game.elements.enemies.EnemyController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.powerups.ActivePowerUp;
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
    private final ActivePowerUpController activePowerUpController;
    private boolean checkpoint1;
    private boolean checkpoint2;

    // Used for tests (dependencyInjection)
    @VisibleForTesting
    public MapController(Map map,
                         ChellController chellController,
                         BulletController bulletController,
                         PlatformController platformController,
                         CoinController coinController,
                         EnemyController enemyController,
                         CloudController cloudController,
                         PowerUpController powerUpController,
                         ActivePowerUpController activePowerUpController,
                         long addedScoreTimer){
        super(map);
        this.chellController = chellController;
        this.bulletController = bulletController;
        this.platformController = platformController;
        this.coinController = coinController;
        this.enemyController = enemyController;
        this.cloudController = cloudController;
        this.powerUpController = powerUpController;
        this.activePowerUpController = activePowerUpController;
        this.checkpoint1 = false;
        this.checkpoint2 = false;
        this.addedScoreTimer = addedScoreTimer;
    }

    public MapController(Map map){
        super(map);
        this.chellController = new ChellController(map);
        this.bulletController = new BulletController(map);
        this.platformController = new PlatformController(map);
        this.coinController = new CoinController(map);
        this.enemyController = new EnemyController(map);
        this.cloudController = new CloudController(map);
        this.powerUpController = new PowerUpController(map);
        this.activePowerUpController = new ActivePowerUpController(map);
        this.checkpoint1 = false;
        this.checkpoint2 = false;
        getModel().setGameStartTime(System.currentTimeMillis());
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        enemyController.step(game, action, time);
        bulletController.step(game, action, time);
        chellController.step(game, action, time);
        platformController.step(game, action, time);
        coinController.step(game, action, time);
        cloudController.step(game, action, time);
        powerUpController.step(game, action, time);
        activePowerUpController.step(game, action, time);

        // adds 1 point per second
        if (System.currentTimeMillis() - addedScoreTimer >= 1000) {
            setAddedScoreTimer(System.currentTimeMillis());
            getModel().setScore(getModel().getScore() + 1);
        }

        // Checks if game is over
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
        if (!checkpoint1 && elapsedTimeSinceGameStart >= 30){
            checkpoint1 = true;
            getModel().setShiftCooldown(0.05);
            getModel().setSpawnCooldown(4);
        } else if (!checkpoint2 && elapsedTimeSinceGameStart >= 120){
            checkpoint2 = true;
            getModel().setShiftCooldown(0.03);
            getModel().setSpawnCooldown(3);
        }
    }

    public boolean isGameOver() {
        // The game is over if Chell falls out of bounds, gets behind the left border or has no lives left
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
