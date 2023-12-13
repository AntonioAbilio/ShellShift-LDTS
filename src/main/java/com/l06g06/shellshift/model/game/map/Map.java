package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;
import com.l06g06.shellshift.model.game.spawners.CoinSpawner;
import com.l06g06.shellshift.model.game.spawners.EnemySpawner;
import com.l06g06.shellshift.model.game.spawners.PlatformSpawner;
import com.l06g06.shellshift.model.game.spawners.PowerUpSpawner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Map {
    private int score = 0;

    // DEBUG
    private Chell chell = new Chell(new Position(120,0));
    private Gun gun;
    private List<Enemy> enemies = new ArrayList<>(0);
    private List<Platform> platforms = new ArrayList<>(0);
    private List<Bullet> bullets = new ArrayList<>(0);
    private List<PowerUp> powerUps = new ArrayList<>(0);
    private List<Coin> coins = new ArrayList<>(0);
    private List<Cloud> clouds = new ArrayList<>(0);

    private final PlatformSpawner platformSpawner;
    private final CoinSpawner coinSpawner;
    private final EnemySpawner enemySpawner;
    private final PowerUpSpawner powerUpSpawner;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    private int coinsCollected = 0;
    private int monstersKilled = 0;

    // Sizes
    public Map() {
        this.gun = new Gun(new NormalFireStrategy());
        this.bullets = new ArrayList<>();

        //plataforma inicial
        this.platforms.add(new Platform(new Position(140, 55)));
        this.platforms.add(new Platform(new Position(210, 35)));
        this.platformSpawner = new PlatformSpawner(platforms);
        this.coinSpawner = new CoinSpawner(coins);
        this.enemySpawner = new EnemySpawner(enemies);
        this.powerUpSpawner = new PowerUpSpawner(powerUps);

        startCloudAddingTask();

    }

    public void startCloudAddingTask() {
        Random rand = new Random();
        executorService.scheduleAtFixedRate(this::addCloud, 0, 10 + rand.nextInt(15), TimeUnit.SECONDS);
    }
    public void stopCloudAddingTask(){
        executorService.shutdown();
    }

    private void addCloud() {
        Random rand = new Random();
        Cloud newCloud = new Cloud(new Position(160, 8 + rand.nextInt(70)));
        this.clouds.add(newCloud);
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

    // Bullets
    public List<Bullet> getBullets() {
        return bullets;
    }

    public void addBullet(Bullet bullet) {
        this.bullets.add(bullet);
    }

    // PowerUps
    public List<PowerUp> getPowerUps(){
        return powerUps;
    }

    // Coins
    public List<Coin> getCoins(){
        return coins;
    }

    public PlatformSpawner getPlatformSpawner() {
        return platformSpawner;
    }

    public CoinSpawner getCoinSpawner() {
        return coinSpawner;
    }

    public EnemySpawner getEnemySpawner() {
        return enemySpawner;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        if (this.score > Database.getInstance().getMAXSCORE()) this.score = Database.getInstance().getMAXSCORE();
    }

    public void addCoin() {
        this.coinsCollected++;
    }

    public int getCoinsCollected() {
        return coinsCollected;
    }

    public int getMonstersKilled() {
        return monstersKilled;
    }

    public void addMonsterKilled(){
        monstersKilled++;
    }

    public List<Cloud> getClouds() {
        return clouds;
    }

    public PowerUpSpawner getPowerUpSpawner() {
        return this.powerUpSpawner;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }
}
