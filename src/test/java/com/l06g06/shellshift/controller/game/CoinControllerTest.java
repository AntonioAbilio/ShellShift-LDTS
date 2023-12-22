package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.CoinController;
import com.l06g06.shellshift.controller.game.elements.PlatformController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.game.spawners.CoinSpawner;
import com.l06g06.shellshift.model.game.spawners.PlatformSpawner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class CoinControllerTest {
    private Map mockedMap;
    private List<Coin> coins;
    private CoinController coinController;
    private Game game;
    private List<Gui.PressedKey> action;
    private long timeMillis;


    @BeforeEach
    void setup(){
        Database.getInstance().setSound(false);  // ToDo: Turn off sound on every test class
        this.mockedMap = mock(Map.class);
        this.coins = new ArrayList<>();
        Mockito.when(mockedMap.getCoins()).thenReturn(coins);
        Mockito.when(mockedMap.getPlatforms()).thenReturn(new ArrayList<>(List.of(new Platform(new Position(230, 50)))));
        Mockito.when(mockedMap.getCoinSpawner()).thenReturn(Mockito.mock(CoinSpawner.class));
        this.coinController = new CoinController(mockedMap);

        this.game = mock(Game.class);
        this.action = new ArrayList<>();
        this.timeMillis = 0;

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
        Map map = new Map();
        map.setCoins(coins);
        map.setScore(3 * coins.get(0).value);
        map.setCoinsCollected(3);
        coinController = new CoinController(map);

        // Chell intersects coin1
        Position chellPosition = new Position(3, 1);    // Chell intersects coin1 in this position
        Chell chell = new Chell(chellPosition);
        map.setChell(chell);

        Assertions.assertEquals(3, coins.size());
        coinController.coinCollision();
        Assertions.assertEquals(2, coins.size());
        Assertions.assertEquals(4, map.getCoinsCollected());

        // Chell does not intersect any coin
        map.setScore(0);
        map.setCoinsCollected(0);
        chellPosition = new Position(0, 0);    // Chell does not intersect any coin in this position
        chell.setPosition(chellPosition);

        Assertions.assertEquals(2, coins.size());
        coinController.coinCollision();
        Assertions.assertEquals(2, coins.size());
        Assertions.assertEquals(0, map.getCoinsCollected());
        Assertions.assertEquals(0, map.getScore());
    }

    @Test
    void stepTest(){
        try {
            Position chellPosition = new Position(3, 1);    // Chell intersects coin1 in this position
            Chell chell = new Chell(chellPosition);
            Mockito.when(mockedMap.getChell()).thenReturn(chell);
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
        Mockito.when(mockedMap.getChell()).thenReturn(chell);
        long time = 6000; // 6 seconds
        coinController.setLastSpawnTime(0);
        Mockito.when(mockedMap.getSpawnCooldown()).thenReturn(2);
        coinController.setLastShiftTime(0);

        try {
            coinController.step(game, action, time);
            Assertions.assertEquals((double) time / 1000, coinController.getLastSpawnTime());
            Assertions.assertEquals((double) time / 1000, coinController.getLastShiftTime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void stepShiftConditionTest(){
        Position chellPosition = new Position(3, 1);
        Chell chell = new Chell(chellPosition);
        Mockito.when(mockedMap.getChell()).thenReturn(chell);
        long time1 = 79;
        long time2 = 80;
        long time3 = 81;
        coinController.setLastShiftTime(0);
        Mockito.when(mockedMap.getShiftCooldown()).thenReturn(0.08);

        try {
            coinController.step(game, action, time1);
            Assertions.assertEquals(0, coinController.getLastShiftTime());
            coinController.step(game, action, time2);
            Assertions.assertEquals(0.08, coinController.getLastShiftTime());
            CoinController coinControllerSpy = spy(coinController);
            coinControllerSpy.setLastShiftTime(0);
            coinControllerSpy.step(game, action, time2);
            verify(coinControllerSpy, times(1)).left_shift();
            coinController.step(game, action, time3);
            Assertions.assertEquals(0.08, coinController.getLastShiftTime());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void stepSpawnConditionTest(){
        mockedMap = mock(Map.class);
        coinController = new CoinController(mockedMap);
        Chell chell = new Chell(new Position(3, 1));
        when(mockedMap.getChell()).thenReturn(chell);
        List<Platform> platforms = new ArrayList<>();
        Platform platform1 = new Platform(new Position(2, 2));
        platforms.add(platform1);
        when(mockedMap.getPlatforms()).thenReturn(platforms);

        long time1 = 5999;
        long time2 = 6000;
        long time3 = 6001;
        coinController.setLastSpawnTime(0);
        when(mockedMap.getSpawnCooldown()).thenReturn(6);

        try {
            coinController.step(game, action, time1);
            Assertions.assertEquals(0, coinController.getLastSpawnTime());
            coinController.step(game, action, time2);
            Assertions.assertEquals(6, coinController.getLastSpawnTime());
            coinController.step(game, action, time3);
            Assertions.assertEquals(6, coinController.getLastSpawnTime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void spawnOnPlatformTest(){
        Platform platform = mock(Platform.class);
        CoinSpawner coinSpawner = mock(CoinSpawner.class);
        when(mockedMap.getPlatforms()).thenReturn(Arrays.asList(platform));
        when(mockedMap.getCoinSpawner()).thenReturn(coinSpawner);
        when(platform.getPosition()).thenReturn(new Position(300, 200));
        when(platform.getPolygon()).thenReturn(new Polygon(new int[]{0, 1, 2}, new int[]{0, 1, 2}, 3));

        coinController.spawnOnPlatform();

        verify(coinSpawner, times(1)).spawn(any(Position.class));
    }

    @Test
    public void spawnOnPlatformNoPlatformFoundTest() {
        Platform platform = mock(Platform.class);
        CoinSpawner coinSpawner = mock(CoinSpawner.class);
        when(mockedMap.getPlatforms()).thenReturn(Arrays.asList(platform));
        when(mockedMap.getCoinSpawner()).thenReturn(coinSpawner);
        when(platform.getPosition()).thenReturn(new Position(100, 200));
        when(platform.getPolygon()).thenReturn(new Polygon(new int[]{0, 1, 2}, new int[]{0, 1, 2}, 3));

        coinController.spawnOnPlatform();

        // Verify that the spawn method was not called
        verify(coinSpawner, never()).spawn(any(Position.class));
    }

}
