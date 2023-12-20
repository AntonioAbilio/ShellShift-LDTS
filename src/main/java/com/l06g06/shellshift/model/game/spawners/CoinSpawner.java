package com.l06g06.shellshift.model.game.spawners;

import com.l06g06.shellshift.model.creators.CoinCreator;
import com.l06g06.shellshift.model.factories.CoinFactory;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Position;

import java.util.List;

public class CoinSpawner {
    private CoinCreator coinCreator;
    private CoinFactory coinFactory;
    private List<Coin> coins;

    public CoinSpawner(List<Coin> coins){
        this.coins = coins;
        this.coinCreator = new CoinCreator();
        this.coinFactory = new CoinFactory();
    }

    public void spawn(Position position){
        Coin spawned_coin = (Coin) coinCreator.create(position);
        //Coin spawned_coin = (Coin) coinFactory.create(position);
        coins.add(spawned_coin);
        coins.removeIf(coin -> coin.getPosition().getX() <= -30);
    }
}
