package com.l06g06.shellshift.model.menus;

import java.util.Arrays;
import java.util.List;

public class ShopMenu extends Menu {
    protected ShopMenu() {
        super(Arrays.asList("Rapid Fire", "Shotgun", "More Damage", "Main Menu"));
    }

    public boolean isSelectedMainMenu() {
        return isSelected(3);
    }
}
