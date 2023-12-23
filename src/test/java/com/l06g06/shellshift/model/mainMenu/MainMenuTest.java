package com.l06g06.shellshift.model.mainMenu;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuTest {
    private MainMenu mainMenu;

    @BeforeEach
    public void setUp() {
        Database.getInstance().setSound(true);
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
        int i = 0;
        Assertions.assertFalse(mainMenu.getOptions().isEmpty());
        while (!mainMenu.isSelectedShop()){
            if (i >= 5) fail();
            mainMenu.nextOption();
            i++;
        }
        if (i != 1) fail();
        assertTrue(mainMenu.isSelected(i));
        assertFalse(mainMenu.isSelectedQuit());
        assertFalse(mainMenu.isSelectedOptions());
        assertFalse(mainMenu.isSelectedStatistics());
        assertFalse(mainMenu.isSelectedTutorial());
        assertFalse(mainMenu.isSelectedStart());
        assertTrue(mainMenu.isSelectedShop());

        while (!mainMenu.isSelectedQuit()){
            if (i >= 5) fail();
            mainMenu.nextOption();
            i++;
        }
        assertTrue(mainMenu.isSelected(i));
        assertTrue(mainMenu.isSelectedQuit());
        assertFalse(mainMenu.isSelectedOptions());
        assertFalse(mainMenu.isSelectedStatistics());
        assertFalse(mainMenu.isSelectedTutorial());
        assertFalse(mainMenu.isSelectedStart());
        assertFalse(mainMenu.isSelectedShop());
        if (i != 5) fail();
    }

    @Test
    public void isSelectedStartTest() {
        int i = 0;
        Assertions.assertFalse(mainMenu.getOptions().isEmpty());
        while (!mainMenu.isSelectedStart()){
            if (i >= 5) fail();
            mainMenu.nextOption();
            i++;
        }
        if (i != 0) fail();
        assertTrue(mainMenu.isSelected(i));
        assertFalse(mainMenu.isSelectedQuit());
        assertFalse(mainMenu.isSelectedOptions());
        assertFalse(mainMenu.isSelectedStatistics());
        assertFalse(mainMenu.isSelectedTutorial());
        assertTrue(mainMenu.isSelectedStart());
        assertFalse(mainMenu.isSelectedShop());

        while (!mainMenu.isSelectedQuit()){
            if (i >= 5) fail();
            mainMenu.nextOption();
            i++;
        }
        assertTrue(mainMenu.isSelected(i));
        assertTrue(mainMenu.isSelectedQuit());
        assertFalse(mainMenu.isSelectedOptions());
        assertFalse(mainMenu.isSelectedStatistics());
        assertFalse(mainMenu.isSelectedTutorial());
        assertFalse(mainMenu.isSelectedStart());
        assertFalse(mainMenu.isSelectedShop());
        if (i != 5) fail();
    }

    @Test
    public void isSelectedQuitTest() {
        int i = 0;
        Assertions.assertFalse(mainMenu.getOptions().isEmpty());
        while (!mainMenu.isSelectedQuit()){
            if (i >= 5) fail();
            mainMenu.nextOption();
            i++;
        }
        if (i != 5) fail();
        assertTrue(mainMenu.isSelected(i));
        assertTrue(mainMenu.isSelectedQuit());
        assertFalse(mainMenu.isSelectedOptions());
        assertFalse(mainMenu.isSelectedStatistics());
        assertFalse(mainMenu.isSelectedTutorial());
        assertFalse(mainMenu.isSelectedStart());
        assertFalse(mainMenu.isSelectedShop());
    }

    @Test
    public void isSelectedTutorial(){
        int i = 0;
        Assertions.assertFalse(mainMenu.getOptions().isEmpty());
        // Let's search trough the menu.
        while (!mainMenu.isSelectedTutorial()){
            if (i >= 5) fail();
            mainMenu.nextOption();
            i++;
        }
        if (i != 2) fail();
        assertTrue(mainMenu.isSelected(i));
        assertFalse(mainMenu.isSelectedQuit());
        assertFalse(mainMenu.isSelectedOptions());
        assertFalse(mainMenu.isSelectedStatistics());
        assertTrue(mainMenu.isSelectedTutorial());
        assertFalse(mainMenu.isSelectedStart());
        assertFalse(mainMenu.isSelectedShop());

        // Now let's make sure that every option still exists.
        while (!mainMenu.isSelectedQuit()){
            if (i >= 5) fail();
            mainMenu.nextOption();
            i++;
        }
        assertTrue(mainMenu.isSelected(i));
        assertTrue(mainMenu.isSelectedQuit());
        assertFalse(mainMenu.isSelectedOptions());
        assertFalse(mainMenu.isSelectedStatistics());
        assertFalse(mainMenu.isSelectedTutorial());
        assertFalse(mainMenu.isSelectedStart());
        assertFalse(mainMenu.isSelectedShop());
        if (i != 5) fail();
    }

    @Test
    public void isSelectedStatistics(){
        int i = 0;
        Assertions.assertFalse(mainMenu.getOptions().isEmpty());
        while (!mainMenu.isSelectedStatistics()){
            if (i >= 5) fail();
            mainMenu.nextOption();
            i++;
        }
        if (i != 3) fail();
        assertTrue(mainMenu.isSelected(i));
        assertFalse(mainMenu.isSelectedQuit());
        assertFalse(mainMenu.isSelectedOptions());
        assertTrue(mainMenu.isSelectedStatistics());
        assertFalse(mainMenu.isSelectedTutorial());
        assertFalse(mainMenu.isSelectedStart());
        assertFalse(mainMenu.isSelectedShop());

        while (!mainMenu.isSelectedQuit()){
            if (i >= 5) fail();
            mainMenu.nextOption();
            i++;
        }
        assertTrue(mainMenu.isSelected(i));
        assertTrue(mainMenu.isSelectedQuit());
        assertFalse(mainMenu.isSelectedOptions());
        assertFalse(mainMenu.isSelectedStatistics());
        assertFalse(mainMenu.isSelectedTutorial());
        assertFalse(mainMenu.isSelectedStart());
        assertFalse(mainMenu.isSelectedShop());
        if (i != 5) fail();
    }

    @Test
    public void isSelectedOptions(){
        int i = 0;
        Assertions.assertFalse(mainMenu.getOptions().isEmpty());
        while (!mainMenu.isSelectedOptions()){
            if (i >= 5) fail();
            mainMenu.nextOption();
            i++;
        }
        if (i != 4) fail();
        assertTrue(mainMenu.isSelected(i));
        assertTrue(mainMenu.isSelectedOptions());
        assertFalse(mainMenu.isSelectedStatistics());
        assertFalse(mainMenu.isSelectedTutorial());
        assertFalse(mainMenu.isSelectedStart());
        assertFalse(mainMenu.isSelectedQuit());
        assertFalse(mainMenu.isSelectedShop());

        while (!mainMenu.isSelectedQuit()){
            if (i >= 5) fail();
            mainMenu.nextOption();
            i++;
        }
        assertTrue(mainMenu.isSelected(i));
        assertTrue(mainMenu.isSelectedQuit());
        assertFalse(mainMenu.isSelectedOptions());
        assertFalse(mainMenu.isSelectedStatistics());
        assertFalse(mainMenu.isSelectedTutorial());
        assertFalse(mainMenu.isSelectedStart());
        assertFalse(mainMenu.isSelectedShop());
        if (i != 5) fail();
    }

    @Test
    public void testForOverflow(){
        int i = 0;
        Assertions.assertFalse(mainMenu.getOptions().isEmpty());
        while (!mainMenu.isSelectedQuit()){
            if (i >= 5) fail();
            mainMenu.nextOption();
            i++;
        }
        mainMenu.nextOption();
        if (!mainMenu.isSelected(5)) fail();
        assertTrue(mainMenu.isSelectedQuit());
        assertFalse(mainMenu.isSelectedOptions());
        assertFalse(mainMenu.isSelectedStatistics());
        assertFalse(mainMenu.isSelectedTutorial());
        assertFalse(mainMenu.isSelectedStart());
        assertFalse(mainMenu.isSelectedShop());
        if (i != 5) fail();
    }

}

