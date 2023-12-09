package com.l06g06.shellshift.controller.game.elements;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CoinController extends GameController {

    double spawnCooldown = 3; // Spawn every 3 seconds
    double shiftCooldown = 0.1; // Shift every 0.1 seconds
    double lastSpawnTime = 0;
    double lastShiftTime = 0;

    public CoinController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {

        double currentTime = time / 1000.0; // Convert to seconds

        // Spawn coin logic
        if (currentTime - lastSpawnTime >= spawnCooldown){
            lastSpawnTime = currentTime;
            getModel().getCoinSpawner().spawn(new Position(110, 50));
        }

        // Shift coin logic
        if (currentTime - lastShiftTime >= shiftCooldown){
            lastShiftTime = currentTime;
            left_shift();
        }
        coinCollision();

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
                getModel().addCoin();
                getModel().setScore(getModel().getScore() + coin.getValue());
            }
        }
    }
}
