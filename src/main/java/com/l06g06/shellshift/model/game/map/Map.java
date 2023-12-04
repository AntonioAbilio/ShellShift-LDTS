package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.gun.Gun;

import java.util.List;

public class Map {
    private final int width;
    private final int height;

    /*// DEBUG
    private Chell chell = new Chell(new Position(10,10));*/

    private Chell chell;
    private Gun gun;
    private List<Enemy> enemies;
    private List<Platform> platforms;
    private List<Bullet> bullets;
    private List<PowerUp> powerups;
    private List<Coin> coins;

    // Sizes
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    // Chell
    public Chell getChell() {
        return this.chell;
    }
    public void setChell(Chell chell) {
        this.chell = chell;
    }

    // Gun
    public Gun getGun() {
        return this.gun;
    }
    public void setGun(Gun gun) {
        this.gun = gun;
    }

    // Enemies
    public List<Enemy> getEnemies() {
        return enemies;
    }
    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    // Platforms
    public List<Platform> getPlatforms() {
        return platforms;
    }
    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    // Bullets
    public List<Bullet> getBullets() {
        return bullets;
    }
    public void setBullets(List<Bullet> bullets){
        this.bullets = bullets;
    }

    // PowerUps
    public List<PowerUp> getPowerups(){
        return powerups;
    }

    public void setPowerups(List<PowerUp> pups) {
        this.powerups = pups;
    }

    // Coins
    public List<Coin> getCoins(){
        return coins;
    }
    public void SetCoins(List<Coin> coins) {
        this.coins = coins;
    }

    // TODO
    // Add enemies, add platforms, add bullets...
}
