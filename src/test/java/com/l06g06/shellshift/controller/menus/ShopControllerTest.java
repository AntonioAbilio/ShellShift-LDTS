package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;
import com.l06g06.shellshift.model.game.gun.RapidFireStrategy;
import com.l06g06.shellshift.model.shop.Shop;
import com.l06g06.shellshift.states.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ShopControllerTest {

    private Shop shop;
    private ShopController shopController;
    private Game game;
    private Database database;

    @BeforeEach
    public void setup(){
        game = mock(Game.class);
        shop = mock(Shop.class);

        shopController = new ShopController(shop);

        Database.setInstance(this.database);
        database = Database.getInstance();
        database.setSound(true);
    }

    @Test
    public void stepSelectTest(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);
        try {
            shopController.step(game, actions, 0);
            verify(shop, times(1)).isSelectedExtraLife();
            verify(shop, times(1)).isSelectedMoreBullets();
            verify(shop, times(1)).isSelectedRapidFire();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    public void stepUpTest(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.UP);
        try {
            shopController.step(game, actions, 0);
            verify(shop, times(1)).prevOption();
            verify(shop, times(0)).nextOption();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    public void stepDownTest(){
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.DOWN);
        try {
            shopController.step(game, actions, 0);
            verify(shop, times(0)).prevOption();
            verify(shop, times(1)).nextOption();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    public void selectExtraLifesTest() {
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(shop.isSelectedExtraLife()).thenReturn(true);
        when(shop.getPrice(Components.ExtraLife)).thenReturn(20);

        when(shop.isSelectedMoreBullets()).thenReturn(false);
        when(shop.getPrice(Components.MoreBullets)).thenReturn(10);

        when(shop.isSelectedRapidFire()).thenReturn(false);
        when(shop.getPrice(Components.RapidFire)).thenReturn(50);


        database.addCoins(999);

        int expectedNumberOfLives = 0;
        int expectedNumberOfCoins = 0;
        while (database.getNumLives() != 8){

            expectedNumberOfLives = database.getNumLives() + 1;
            expectedNumberOfCoins = database.getNumCoins() - 20;

            try {
                shopController.step(game, actions, 0);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                fail();
            }

            Assertions.assertEquals(expectedNumberOfLives, database.getNumLives());
            Assertions.assertEquals(expectedNumberOfCoins, database.getNumCoins());
        }

        expectedNumberOfLives = 8;
        expectedNumberOfCoins = 899;

        try {
            shopController.step(game, actions, 0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        Assertions.assertEquals(expectedNumberOfLives, database.getNumLives());
        Assertions.assertEquals(expectedNumberOfCoins, database.getNumCoins());

        verify(shop, times(6)).isSelectedExtraLife();
        verify(shop, times(6)).isSelectedMoreBullets();
        verify(shop, times(6)).isSelectedRapidFire();

        verify(game, times(5)).setState(Mockito.any(MainMenuState.class)); // If not enough money it does not kick us out of the store

        verify(game, never()).setState(Mockito.any(ShopState.class));
        verify(game, never()).setState(Mockito.any(StatisticsState.class));
        verify(game, never()).setState(Mockito.any(TutorialState.class));
        verify(game, never()).setState(Mockito.any(OptionsMenuState.class));
        verify(game, never()).setState(null);


    }

    @Test
    public void selectMoreBulletsTest() {
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(shop.isSelectedExtraLife()).thenReturn(false);
        when(shop.getPrice(Components.ExtraLife)).thenReturn(20);

        when(shop.isSelectedMoreBullets()).thenReturn(true);
        when(shop.getPrice(Components.MoreBullets)).thenReturn(10);

        when(shop.isSelectedRapidFire()).thenReturn(false);
        when(shop.getPrice(Components.RapidFire)).thenReturn(50);


        database.addCoins(999);

        int expectedNumberOfStartingBullets = 0;
        int expectedNumberOfCoins = 0;
        while (database.getStartingNumBullets() != database.getMAXBULLETS()){

            // Top Up
            if (database.getNumCoins() == 9){
                database.addCoins(999);
                Assertions.assertEquals(999, database.getNumCoins());
            }

            expectedNumberOfStartingBullets = database.getStartingNumBullets() + 10;
            expectedNumberOfCoins = database.getNumCoins() - 10;

            try {
                shopController.step(game, actions, 0);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                fail();
            }

            Assertions.assertEquals(expectedNumberOfStartingBullets, database.getStartingNumBullets());
            Assertions.assertEquals(expectedNumberOfCoins, database.getNumCoins());
        }

        // Let's try to buy one more to check if the starting bullets are still 200.
        database.setNumCoins(10);

        expectedNumberOfStartingBullets = 200;
        expectedNumberOfCoins = 10;

        try {
            shopController.step(game, actions, 0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        Assertions.assertEquals(expectedNumberOfStartingBullets, database.getStartingNumBullets());
        Assertions.assertEquals(expectedNumberOfCoins, database.getNumCoins());

        verify(shop, times(18)).isSelectedExtraLife();
        verify(shop, times(18)).isSelectedMoreBullets();
        verify(shop, times(18)).isSelectedRapidFire();

        verify(game, times(17)).setState(Mockito.any(MainMenuState.class));

        verify(game, never()).setState(Mockito.any(ShopState.class));
        verify(game, never()).setState(Mockito.any(StatisticsState.class));
        verify(game, never()).setState(Mockito.any(TutorialState.class));
        verify(game, never()).setState(Mockito.any(OptionsMenuState.class));
        verify(game, never()).setState(null);
    }

    @Test
    public void selectRapidFireTest() {
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.SELECT);

        when(shop.isSelectedExtraLife()).thenReturn(false);
        when(shop.getPrice(Components.ExtraLife)).thenReturn(20);

        when(shop.isSelectedMoreBullets()).thenReturn(false);
        when(shop.getPrice(Components.MoreBullets)).thenReturn(10);

        when(shop.isSelectedRapidFire()).thenReturn(true);
        when(shop.getPrice(Components.RapidFire)).thenReturn(50);


        database.addCoins(999);
        int expectedNumberOfCoins = database.getNumCoins() - 50;

        Assertions.assertTrue(database.getFiringStrategy() instanceof NormalFireStrategy);

        try {
            shopController.step(game, actions, 0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        Assertions.assertTrue(database.getFiringStrategy() instanceof RapidFireStrategy);
        Assertions.assertEquals(expectedNumberOfCoins, database.getNumCoins());

        expectedNumberOfCoins = database.getNumCoins();

        try {
            shopController.step(game, actions, 0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        Assertions.assertTrue(database.getFiringStrategy() instanceof RapidFireStrategy);
        Assertions.assertEquals(expectedNumberOfCoins, database.getNumCoins());


        verify(shop, times(2)).isSelectedExtraLife();
        verify(shop, times(2)).isSelectedMoreBullets();
        verify(shop, times(2)).isSelectedRapidFire();



        verify(game, times(1)).setState(Mockito.any(MainMenuState.class));

        verify(game, never()).setState(Mockito.any(ShopState.class));
        verify(game, never()).setState(Mockito.any(StatisticsState.class));
        verify(game, never()).setState(Mockito.any(TutorialState.class));
        verify(game, never()).setState(Mockito.any(OptionsMenuState.class));
        verify(game, never()).setState(null);
    }

    @Test
    public void ExitTest() {
        List<Gui.PressedKey> actions = List.of(Gui.PressedKey.EXIT);

        // No matter what option is selected the shop should exit and not spend or change anything in the database.
        when(shop.isSelectedExtraLife()).thenReturn(true);
        when(shop.isSelectedMoreBullets()).thenReturn(true);
        when(shop.isSelectedRapidFire()).thenReturn(true);

        database.setNumCoins(10);
        database.setNumLives(3);
        database.addStartingBullets(30);
        database.setFiringStrategy(new NormalFireStrategy());


        int expectedLives = database.getNumLives();
        int expectedStartingBullets = database.getStartingNumBullets();
        int expectedCoins = database.getNumCoins();
        FireStrategy expectedFireStrategy = database.getFiringStrategy();


        try {
            shopController.step(game, actions, 100);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }

        Assertions.assertEquals(expectedLives, database.getNumLives());
        Assertions.assertEquals(expectedStartingBullets, database.getStartingNumBullets());
        Assertions.assertEquals(expectedCoins, database.getNumCoins());
        Assertions.assertEquals(expectedFireStrategy, database.getFiringStrategy());

        verify(shop, times(0)).isSelectedExtraLife();
        verify(shop, times(0)).isSelectedMoreBullets();
        verify(shop, times(0)).isSelectedRapidFire();

        verify(game, never()).setState(Mockito.any(GameState.class));
        verify(game, never()).setState(Mockito.any(ShopState.class));
        verify(game, never()).setState(Mockito.any(StatisticsState.class));
        verify(game, never()).setState(Mockito.any(TutorialState.class));
        verify(game, never()).setState(Mockito.any(OptionsMenuState.class));
        verify(game, never()).setState(null);

        verify(game, times(1)).setState(Mockito.any(MainMenuState.class));
    }

}
