package com.l06g06.shellshift.model.menus;

import java.util.Arrays;
import java.util.List;

public class GameOverMenu extends Menu{

    protected GameOverMenu() {
        super(Arrays.asList("Restart", "Main Menu", "Quit"));
    }

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public boolean isSelectedQuit() {
        return isSelected(getOptionsSize());
    }

    public boolean isSelectedMainMenu() {
        return isSelected(1);
    }
}
