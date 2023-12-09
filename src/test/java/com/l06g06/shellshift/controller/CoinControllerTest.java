package com.l06g06.shellshift.controller;

import com.l06g06.shellshift.controller.game.elements.CoinController;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class CoinControllerTest {
    Map map ;
    Coin coin;
    List<Coin> coins;
    CoinController coinController;


    @BeforeEach
    public void setup(){
        this.map = mock(Map.class);
        this.coin = mock(Coin.class);
        this.coins = new ArrayList<>();
        Mockito.when(map.getCoins()).thenReturn(coins);
        this.coinController = new CoinController(map);

        Coin coin1 = new Coin(new Position(1,  0));
        Coin coin2 = new Coin(new Position(5, 5));
        Coin coin3 = new Coin(new Position(2, 9));
        coins.add(coin1);
        coins.add(coin2);
        coins.add(coin3);
    }

    @Test
    public void leftShiftTest(){
        // Check if coin is left shifting correctly
        coinController.left_shift();
        Position expectedPos = new Position(0, 0);
        Assertions.assertEquals(expectedPos, coins.get(0).getPosition());
    }

    @Test
    public void coinCollisionTest(){
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

        // ToDo: remove
        /*
        int test_x_inf = -20;
        int test_x_sup = 20;
        int test_y_inf = -30;
        int test_y_sup = 30;
        boolean intersectionFound = false;

        for (int i = test_x_inf; i <= test_x_sup && !intersectionFound; i++) {
            for (int j = test_y_inf; j <= test_y_sup && !intersectionFound; j++) {
                // Update Chell's position
                chell.setPosition(new Position(i, j));

                // Check for intersection
                if (chell.getPolygon().intersects(coin1.getPolygon().getBounds2D())) {
                    System.out.println("Intersection found at x: " + i + " y: " + j);
                    intersectionFound = true;
                }
            }
        }*/
    }
}
