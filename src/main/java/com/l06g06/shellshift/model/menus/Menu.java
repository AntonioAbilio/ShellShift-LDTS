package com.l06g06.shellshift.model.menus;

import java.util.Arrays;
import java.util.List;

public abstract class Menu {
    private final List<String> options;

    private int currOption = 0;

    protected Menu(List<String> options) {
        this.options = options;
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

    public int getCurrOption() { return this.currOption; }
}
