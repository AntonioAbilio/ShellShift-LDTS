package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.CoinController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.game.spawners.CoinSpawner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

public class CoinControllerTest {
    private Map map ;
    private List<Coin> coins;
    private CoinController coinController;
    private Game game;
    private List<Gui.PressedKey> action;
    private long timeMillis;


    @BeforeEach
    void setup(){
        this.map = mock(Map.class);
        this.coins = new ArrayList<>();
        Mockito.when(map.getCoins()).thenReturn(coins);
        Mockito.when(map.getPlatforms()).thenReturn(new ArrayList<>(List.of(new Platform(new Position(230, 50)))));
        Mockito.when(map.getCoinSpawner()).thenReturn(Mockito.mock(CoinSpawner.class));
        this.coinController = new CoinController(map);

        game = mock(Game.class);
        this.action = new ArrayList<>();
        timeMillis = 0;

        Coin coin1 = new Coin(new Position(1,  0));
        Coin coin2 = new Coin(new Position(5, 5));
        Coin coin3 = new Coin(new Position(2, 9));
        coins.add(coin1);
        coins.add(coin2);
        coins.add(coin3);
    }

    @Test
    void leftShiftTest(){
        // Check if coin is left shifting correctly
        coinController.left_shift();
        Position expectedPos = new Position(0, 0);
        Assertions.assertEquals(expectedPos, coins.get(0).getPosition());
    }

    @Test
    void coinCollisionTest(){
        // Chell intersects coin1
        Position chellPosition = new Position(3, 1);    // Chell intersects coin1 in this position
        Chell chell = new Chell(chellPosition);
        Mockito.when(map.getChell()).thenReturn(chell);

        Assertions.assertEquals(3, coins.size());
        coinController.coinCollision();
        Assertions.assertEquals(2, coins.size());


        // Chell does not intersect any coin
        chellPosition = new Position(0, 0);    // Chell does not intersect any coin in this position
        chell.setPosition(chellPosition);

        Assertions.assertEquals(2, coins.size());
        coinController.coinCollision();
        Assertions.assertEquals(2, coins.size());
    }

    @Test
    void stepTest(){
        try {
            Position chellPosition = new Position(3, 1);    // Chell intersects coin1 in this position
            Chell chell = new Chell(chellPosition);
            Mockito.when(map.getChell()).thenReturn(chell);
            CoinController spyCoinController = Mockito.spy(coinController);
            spyCoinController.step(game, action, timeMillis);
            Mockito.verify(spyCoinController, Mockito.times(1)).spawnOnPlatform();
            Mockito.verify(spyCoinController, Mockito.times(1)).left_shift();
            Mockito.verify(spyCoinController, Mockito.times(1)).coinCollision();
        } catch (IOException e){
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void stepConditionTest(){
        Position chellPosition = new Position(3, 1);    // Chell intersects coin1 in this position
        Chell chell = new Chell(chellPosition);
        Mockito.when(map.getChell()).thenReturn(chell);
        long time = 6000; // 6 seconds
        coinController.setLastSpawnTime(0);
        Mockito.when(map.getSpawnCooldown()).thenReturn(2);
        coinController.setLastShiftTime(0);

        try {
            coinController.step(game, action, time);
            Assertions.assertEquals(time / 1000, coinController.getLastSpawnTime());
            Assertions.assertEquals(time / 1000, coinController.getLastShiftTime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
