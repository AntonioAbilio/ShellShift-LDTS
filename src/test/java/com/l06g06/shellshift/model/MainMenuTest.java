package com.l06g06.shellshift.model;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuTest {
    private MainMenu mainMenu;

    @BeforeEach
    public void setUp() {
        mainMenu = new MainMenu();
    }

    @Test
    public void getOptionsTest() {
        List<Components> expected = Arrays.asList(Components.Start, Components.Shop, Components.Tutorial, Components.Statistics, Components.Options, Components.Quit);
        assertEquals(expected, mainMenu.getOptions());
    }

    @Test
    public void nextOptionTest() {
        mainMenu.nextOption();
        assertEquals(1, mainMenu.getCurrOption());
    }

    @Test
    public void prevOptionTest() {
        mainMenu.prevOption();
        assertEquals(0, mainMenu.getCurrOption());
    }

    @Test
    public void getCurrOptionTest() {
        assertEquals(0, mainMenu.getCurrOption());
    }

    @Test
    public void isSelectedTest() {
        assertTrue(mainMenu.isSelected(0));
        assertFalse(mainMenu.isSelected(1));
    }

    @Test
    public void getOptionsSizeTest() {
        assertEquals(6, mainMenu.getOptionsSize());
    }

    @Test
    public void isSelectedShopTest() {
        assertFalse(mainMenu.isSelectedShop());
        mainMenu.nextOption();
        assertTrue(mainMenu.isSelectedShop());
    }
    /*
    @Test
    public void isSelectedStatisticsTest() {
        assertFalse(mainMenu.isSelectedRanking());
        mainMenu.nextOption();
        mainMenu.nextOption();
        assertTrue(mainMenu.isSelectedRanking());
    }

     */

    @Test
    public void isSelectedStartTest() {
        assertTrue(mainMenu.isSelectedStart());
    }

    @Test
    public void isSelectedQuitTest() {
        assertFalse(mainMenu.isSelectedQuit());
        for (int i = 0; i < mainMenu.getOptionsSize(); i++) {
            mainMenu.nextOption();
        }
        assertTrue(mainMenu.isSelectedQuit());
    }

}

