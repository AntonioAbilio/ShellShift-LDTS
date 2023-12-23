package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.spawners.CoinSpawner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinSpawnerTest {
    private CoinSpawner coinSpawner;
    private List<Coin> coins;

    @BeforeEach
    void setUp() {
        Database.getInstance().setSound(true);
        this.coins = new ArrayList<>();
        this.coinSpawner = new CoinSpawner(coins);
    }

    @Test
    void spawnTest() {
        Position position = new Position(50, 50);
        coinSpawner.spawn(position);
        assertEquals(1, coins.size());
        assertEquals(position.getX(), coins.get(0).getPosition().getX()); // Y will be randomized and tested in the Creator
    }

    @Test
    void removeTest() {
        coins.add(new Coin(new Position(-31, 40)));  // should be removed
        coinSpawner.spawn(new Position(10, 10));
        assertEquals(1, coins.size());

        coins.add(new Coin(new Position(-30, 40)));  // should be removed
        coinSpawner.spawn(new Position(10, 10));
        assertEquals(2, coins.size());

        coins.add(new Coin(new Position(-29, 40)));  // should not be removed
        coinSpawner.spawn(new Position(10, 10));
        assertEquals(4, coins.size());
    }
}
