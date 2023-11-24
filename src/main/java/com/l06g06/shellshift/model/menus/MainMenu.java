package com.l06g06.shellshift.model.menus;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu{
    public MainMenu() {
        super(Arrays.asList("Start", "Shop", "Ranking", "Quit"));
    }

    public boolean isSelectedShop() {
        return isSelected(1);
    }

    public boolean isSelectedRanking() {
        return isSelected(2);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedQuit() {
        return isSelected(getOptionsSize());
    }

}
