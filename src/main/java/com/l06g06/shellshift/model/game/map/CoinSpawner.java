package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.creators.CoinCreator;
import com.l06g06.shellshift.model.creators.PlatformCreator;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;

import java.util.List;

public class CoinSpawner {
    int i = 0;

    private CoinCreator coinCreator;
    private List<Coin> coins;

    public CoinSpawner(List<Coin> coins){
        this.coins = coins;
        this.coinCreator = new CoinCreator();
    }

    public void spawn(Position position){
        Coin spawned_coin = (Coin) coinCreator.create(position);
        coins.add(spawned_coin);
        for (int i = 0; i < coins.size(); i++){
            if (coins.get(i).getPosition().getX() <= 40) coins.remove(i);
        }
    }
}
