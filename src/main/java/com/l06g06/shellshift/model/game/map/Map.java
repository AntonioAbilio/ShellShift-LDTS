package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.gun.Gun;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int width;
    private final int height;

    // DEBUG
    private Chell chell = new Chell(new Position(80,80));

    /*private Chell chell;*/
    private Gun gun;
    private List<Enemy> enemies;
    private List<Platform> platforms = new ArrayList<>();
    private List<Bullet> bullets;
    private List<PowerUp> powerups;
    private List<Coin> coins = new ArrayList<>();
    private PlatformSpawner platformSpawner;
    private CoinSpawner coinSpawner;

    // Sizes
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        // DEBUG
        /*Platform platform1 = new Platform(new Position(10, 10));
        Platform platform2 = new Platform(new Position(20, 30));
        platforms.add(platform1);
        platforms.add(platform2);*/
        this.platformSpawner = new PlatformSpawner(platforms);
        this.coinSpawner = new CoinSpawner(coins);
        // Debug
        List<Bullet> bulls = new ArrayList<>();
        Bullet bull = new Bullet(new Position(10, 10));
        bulls.add(bull);
        this.bullets = bulls;
        /*SoftMonster softMonster1 = new SoftMonster(new Position(1, 1));
        SoftMonster softMonster2 = new SoftMonster(new Position(10, 10));
        SoftMonster softMonster3 = new SoftMonster(new Position(80, 80));
        HardMonster hardMonster1 = new HardMonster(new Position(30, 30));
        List<Enemy> softMonsters = new ArrayList<>();
        softMonsters.add(softMonster1);
        softMonsters.add(softMonster2);
        softMonsters.add(softMonster3);
        softMonsters.add(hardMonster1);
        this.enemies = softMonsters; */
        /*Coin coin1 = new Coin(new Position(1, 1));
        Coin coin2 = new Coin(new Position(50, 50));
        Coin coin3 = new Coin(new Position(4, 3));
        List<Coin> coins = new ArrayList<>();
        coins.add(coin1);
        coins.add(coin2);
        coins.add(coin3);*/
        this.coins = coins;

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

    public PlatformSpawner getPlatformSpawner() {
        return platformSpawner;
    }

    public CoinSpawner getCoinSpawner() {
        return coinSpawner;
    }

    // TODO
    // Add enemies, add platforms, add bullets...
}
