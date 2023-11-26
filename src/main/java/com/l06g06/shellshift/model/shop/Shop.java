package com.l06g06.shellshift.model.shop;

import java.util.Arrays;
import java.util.List;

public class Shop {
    private final List<String> options;
    private int currOption = 0;

    public Shop() {
        this.options = Arrays.asList("Rapid Fire......................BUY", "Shotgun.........................BUY", "Increase Bullet Damage..........BUY", "Main Menu");
    }

    public void nextOption() {
        currOption++;
        if (currOption > this.options.size() - 1)
            currOption = 0;
    }

    public void prevOption() {
        currOption--;
        if (currOption < 0)
            currOption = this.options.size()-1;
    }

    public boolean isSelected(int i) {
        return i == currOption;
    }

    public int getOptionsSize() {
        return this.options.size();
    }

    public List<String> getOptions() {
        return this.options;
    }

    public boolean isSelectedMainMenu() {
        return isSelected(3);
    }
}
