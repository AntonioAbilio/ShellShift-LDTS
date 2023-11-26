package com.l06g06.shellshift.model.menus;

import java.util.Arrays;
import java.util.List;

public class RankingMenu extends Menu{
    protected RankingMenu() {
        super(Arrays.asList("Main Menu"));
    }

    public boolean isSelectedMainMenu() {
        return isSelected(0);
    }
}
