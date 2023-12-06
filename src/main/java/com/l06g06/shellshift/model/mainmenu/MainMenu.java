package com.l06g06.shellshift.model.mainmenu;

import com.l06g06.shellshift.Components;

import java.util.Arrays;
import java.util.List;

public class MainMenu {
    private final List<Components> options;
    private int currOption = 0;

    public MainMenu() {
        this.options = Arrays.asList(Components.Start, Components.Shop, Components.Statistics, Components.Quit);
    }

    public List<Components> getOptions(){
        return options;
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

    public int getCurrOption() { return currOption; }

    public boolean isSelected(int i) {
        return i == currOption;
    }

    public int getOptionsSize() {
        return this.options.size();
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
        return isSelected(getOptionsSize() - 1);
    }

}