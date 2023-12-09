package com.l06g06.shellshift.model.tutorial;

import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.VerticalMoveStrategy;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TutorialMap {
    private Chell chell;
    private Gun gun;
    private List<Bullet> bullets;
    private List<Enemy> enemies = new ArrayList<>(0);
    private Platform platform;
    private List<PowerUp> powerUps;
    private List<Coin> coins = new ArrayList<>(0);
    private boolean selectedSpace;
    private boolean selectedArrowUp;
    private boolean selectedArrowLeft;
    private boolean selectedArrowRight;
    private int coinsCollected;

    public TutorialMap() {
        this.gun = new Gun(new NormalFireStrategy());
        this.gun.setNumBullets(50);
        this.bullets = new ArrayList<Bullet>();
        this.chell = new Chell(new Position(55,60));
        this.platform = new Platform(new Position(80, 60));
        this.coins.add(new Coin(new Position(170, 20)));
        this.enemies.add(new SoftMonster(new Position(200, 30), new HorizontalMoveStrategy()));
        this.enemies.add(new HardMonster(new Position(250, 30), new VerticalMoveStrategy()));
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
