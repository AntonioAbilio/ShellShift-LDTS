package com.l06g06.shellshift.controller.game.elements;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.Sound;
import com.l06g06.shellshift.SoundsFx;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.controller.game.MapController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CoinController extends GameController {

    private double lastSpawnTime = 0;
    private double lastShiftTime = 0;
    private Random random;


    public CoinController(Map map) {
        super(map);
        this.random = new Random();
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {

        double currentTime = time / 1000.0; // Convert to seconds

        // Spawn coin logic
        if (currentTime - lastSpawnTime >= getModel().getSpawnCooldown()){
            lastSpawnTime = currentTime;
            spawnOnPlatform();
        }

        // Shift coin logic
        if (currentTime - lastShiftTime >= getModel().getShiftCooldown()){
            lastShiftTime = currentTime;
            left_shift();
        }
        coinCollision();
    }

    public void spawnOnPlatform() {
        List<Platform> platforms = getModel().getPlatforms();

        Platform randomPlatform;
        int i = 0;
        do {
            randomPlatform = platforms.get(random.nextInt(platforms.size()));
            System.out.println("x: " + randomPlatform.getPosition().getX());
            System.out.println("SEARCHING " + i);
            i++;
        } while (randomPlatform.getPosition().getX() < 200 && i < 30);

        if (i >= 30) {
            System.out.println("NOT FOUND");
            return;
        }

        System.out.println("FOUND");
        int minY = 200;
        for (int y : randomPlatform.getPolygon().ypoints) {
            if (y < minY) minY = y;
        }

        int offsetX = random.nextInt(65);

        Position coinPosition = new Position(randomPlatform.getPosition().getX() - offsetX, minY - 18);
        getModel().getCoinSpawner().spawn(coinPosition);
    }

    public void left_shift(){
        for (Coin coin : getModel().getCoins()){
            int x = coin.getPosition().getX();
            int y = coin.getPosition().getY();
            coin.setPosition(new Position(x - 1, y));
        }
    }

    public void coinCollision() {
        List<Coin> coins = getModel().getCoins();
        Iterator<Coin> coinsIterator = coins.iterator();
        while (coinsIterator.hasNext()) {
            Coin coin = coinsIterator.next();

            if (getModel().getChell().getPolygon().intersects(coin.getPolygon().getBounds2D())) {
                coinsIterator.remove();

                //SomAqui Sound.playSound(SoundsFx.Coin);
                Sound sound = Sound.getInstance();
                sound.playSound(SoundsFx.Coin);
                getModel().addCoin();
                getModel().setScore(getModel().getScore() + coin.getValue());
            }
        }
    }
}
