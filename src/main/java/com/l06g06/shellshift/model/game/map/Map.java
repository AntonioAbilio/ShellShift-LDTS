package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.controller.game.elements.enemies.HardMonsterController;
import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;
import com.l06g06.shellshift.model.game.gun.RapidFireStrategy;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int width;
    private final int height;

    private int score = 0;

    // DEBUG
    private Chell chell = new Chell(new Position(130,0));

    /*private Chell chell;*/
    private Gun gun;
    private List<Enemy> enemies = new ArrayList<>(0);
    private List<Platform> platforms = new ArrayList<>(0);
    private List<Bullet> bullets = new ArrayList<>(0);
    private List<PowerUp> powerups = new ArrayList<>(0);
    private List<Coin> coins = new ArrayList<>(0);
    private PlatformSpawner platformSpawner;
    private CoinSpawner coinSpawner;
    //private SoftMonsterSpawner softMonsterSpawner;
    //private HardMonsterSpawner hardMonsterSpawner;
    private EnemySpawner enemySpawner;

    // Sizes
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.gun = new Gun(new NormalFireStrategy());
        this.bullets = new ArrayList<Bullet>();
        // DEBUG
        /*Platform platform1 = new Platform(new Position(10, 10));
        Platform platform2 = new Platform(new Position(20, 30));
        platforms.add(platform1);
        platforms.add(platform2);*/
        this.platformSpawner = new PlatformSpawner(platforms);
        this.coinSpawner = new CoinSpawner(coins);
        //this.softMonsterSpawner = new SoftMonsterSpawner(enemies);
        //this.hardMonsterSpawner = new HardMonsterSpawner(enemies);
        this.enemySpawner = new EnemySpawner(enemies);

        // Debug
        /*List<Bullet> bulls = new ArrayList<>();
        Bullet bull = new Bullet(new Position(10, 10));
        bulls.add(bull);
        this.bullets = bulls;*/
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
        //this.coins = coins;

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

    public void addBullet(Bullet bullet) {
        this.bullets.add(bullet);
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

    public void removeUpdateCoins() {
        for (Coin coin : coins){
            if (coin.getPosition().getX() <= 20){
                coins.remove(0);
            }
        }
    }

    /*public SoftMonsterSpawner getSoftMonsterSpawner() {
        return softMonsterSpawner;
    }

    public HardMonsterSpawner getHardMonsterSpawner() {
        return hardMonsterSpawner;
    }*/

    public EnemySpawner getEnemySpawner() {
        return enemySpawner;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // TODO
    // Add enemies, add platforms, add bullets...
}
