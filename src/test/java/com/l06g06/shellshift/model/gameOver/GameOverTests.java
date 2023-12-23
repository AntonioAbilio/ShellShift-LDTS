package com.l06g06.shellshift.model.gameOver;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameOverTests {
    private GameOver gameOver;

    @BeforeEach
    void setup(){
        Database.getInstance().setSound(true);
        gameOver = new GameOver();
    }

    @Test
    void isSelected(){
        Assertions.assertTrue(gameOver.isSelected(0));
        gameOver.nextOption();
        Assertions.assertTrue(gameOver.isSelected(1));
    }

    @Test
    void previousOption(){
        gameOver.prevOption();
        Assertions.assertTrue(gameOver.isSelected(0));
    }

    @Test
    void nextOption(){
        gameOver.nextOption();
        Assertions.assertTrue(gameOver.isSelected(1));
    }

    @Test
    void nextOptionOverflow(){
        gameOver.nextOption();
        gameOver.nextOption();
        Assertions.assertTrue(gameOver.isSelected(1));
    }

    @Test
    void isSelectedRestart(){
        Assertions.assertTrue(gameOver.isSelectedRestart());
    }

    @Test
    void isSelectedMainMenu(){
        gameOver.nextOption();
        Assertions.assertTrue(gameOver.isSelectedMainMenu());
    }

    @Test
    void gameoverComponents(){
        List<Components> componentsList = new ArrayList<>(0);
        componentsList.add(Components.Restart);
        componentsList.add(Components.MainMenu);
        Assertions.assertEquals(componentsList, gameOver.getOptions());
    }
}
