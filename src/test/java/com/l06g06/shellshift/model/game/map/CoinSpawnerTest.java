package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.creators.CoinCreator;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Position;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CoinSpawnerTest {
    private CoinSpawner coinSpawner;
    private List<Coin> coins;

    @BeforeEach
    void setUp() {
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
        Position position = new Position(40, 40);
        coinSpawner.spawn(position);
        assertEquals(0, coins.size());
    }
}
