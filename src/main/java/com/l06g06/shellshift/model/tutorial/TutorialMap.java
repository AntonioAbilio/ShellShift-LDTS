package com.l06g06.shellshift.model.tutorial;

import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.VerticalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TutorialMap {
    private Chell chell;
    private Gun gun;
    private List<Bullet> bullets;
    private List<Enemy> enemies = new ArrayList<>(0);
    private List<Cloud> clouds = new ArrayList<>(0);
    private Platform platform;
    private List<Coin> coins = new ArrayList<>(0);
    private boolean selectedSpace;
    private boolean selectedArrowUp;
    private boolean selectedArrowLeft;
    private boolean selectedArrowRight;
    private int coinsCollected;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);


    public TutorialMap() {
        this.gun = new Gun(new NormalFireStrategy());
        this.gun.setNumBullets(50);
        this.bullets = new ArrayList<>();
        this.chell = new Chell(new Position(55,60));
        this.platform = new Platform(new Position(80, 60));
        this.coins.add(new Coin(new Position(180, 20)));
        this.enemies.add(new SoftMonster(new Position(200, 30), new HorizontalMoveStrategy()));
        this.enemies.add(new HardMonster(new Position(250, 30), new VerticalMoveStrategy()));
        this.clouds.add(new Cloud(new Position(60,20)));
        startCloudAddingTask();

    }

    public void startCloudAddingTask() {
        Random rand = new Random();
        executorService.scheduleAtFixedRate(this::addCloud, 0, 5 + rand.nextInt(5, 20), TimeUnit.SECONDS);
    }
    public void stopCloudAddingTask(){
        executorService.shutdown();
    }

    private void addCloud() {
        Random rand = new Random();
        Cloud newCloud = new Cloud(new Position(160, 8 + rand.nextInt(0, 30)));
        clouds.add(newCloud);
    }

    public List<Cloud> getClouds() {
        return clouds;
    }

    public boolean isSelectedSpace() {
        return selectedSpace;
    }

    public void setSelectedSpace(boolean selectedSpace) {
        this.selectedSpace = selectedSpace;
    }

    public boolean isSelectedArrowUp() {
        return selectedArrowUp;
    }

    public void setSelectedArrowUp(boolean selectedArrowUp) {
        this.selectedArrowUp = selectedArrowUp;
    }

    public boolean isSelectedArrowLeft() {
        return selectedArrowLeft;
    }

    public void setSelectedArrowLeft(boolean selectedArrowLeft) {
        this.selectedArrowLeft = selectedArrowLeft;

    }

    public boolean isSelectedArrowRight() {
        return selectedArrowRight;
    }

    public void setSelectedArrowRight(boolean selectedArrowRight) {
        this.selectedArrowRight = selectedArrowRight;
    }

    public Chell getChell() {
        return chell;
    }

    public Gun getGun() {
        return gun;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public Platform getPlatform() {
        return platform;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void addBullet(Bullet bullet) {
        this.bullets.add(bullet);
    }

    public int getCoinsCollected() {
        return coinsCollected;
    }

    public void addCoin() {
        this.coinsCollected++;
    }
}
