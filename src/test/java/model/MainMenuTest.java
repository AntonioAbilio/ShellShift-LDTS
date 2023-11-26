package model;

import com.l06g06.shellshift.model.mainmenu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MainMenuTest {

    @Mock
    private List<String> optionsMock;

    private MainMenu mainMenu;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mainMenu = new MainMenu();
    }

    @Test
    void getOptions() {
        assertNotNull(mainMenu.getOptions());
        assertEquals(4, mainMenu.getOptionsSize());
    }

    @Test
    void nextOption() {
        int initialOption = mainMenu.getOptions().indexOf("Start");
        mainMenu.nextOption();
        assertEquals(initialOption + 1, mainMenu.getOptions().indexOf("Shop"));
    }

    @Test
    void prevOption() {
        int initialOption = mainMenu.getOptions().indexOf("Shop");
        mainMenu.prevOption();
        assertEquals(initialOption - 1, mainMenu.getOptions().indexOf("Start"));
    }

    @Test
    void isSelected() {
        assertTrue(mainMenu.isSelected(0));
        assertFalse(mainMenu.isSelected(1));
    }

    @Test
    void isSelectedShop() {
        assertFalse(mainMenu.isSelectedShop());
        mainMenu.nextOption();
        assertTrue(mainMenu.isSelectedShop());
    }

    @Test
    void isSelectedRanking() {
        assertFalse(mainMenu.isSelectedRanking());
        mainMenu.nextOption();
        mainMenu.nextOption();
        assertTrue(mainMenu.isSelectedRanking());
    }

    @Test
    void isSelectedStart() {
        assertTrue(mainMenu.isSelectedStart());
        mainMenu.nextOption();
        assertFalse(mainMenu.isSelectedStart());
    }

    @Test
    void isSelectedQuit() {
        assertFalse(mainMenu.isSelectedQuit());
        mainMenu.nextOption();
        mainMenu.nextOption();
        mainMenu.nextOption();
        assertTrue(mainMenu.isSelectedQuit());
    }
}

