package com.l06g06.shellshift.model.shop;

import com.l06g06.shellshift.Components;

import java.util.Arrays;
import java.util.List;

public class Shop {
    private final List<Components> text;
    private final List<Components> icons;
    private int currOption = 0;

    public Shop() {
        this.text = Arrays.asList(Components.RapidFire,Components.ExtraLife, Components.Quit);
        this.icons = Arrays.asList(Components.RapidFireIcon ,Components.HeartIcon);
    }

    public void nextOption() {
        currOption++;
        if (currOption > this.text.size() - 1)
            currOption = 0;
    }

    public void prevOption() {
        currOption--;
        if (currOption < 0)
            currOption = this.text.size()-1;
    }

    public boolean isSelected(int i) {
        return i == currOption;
    }

    public int getTextSize() {
        return this.text.size();
    }

    public List<Components> getText() {
        return this.text;
    }

    public List<Components> getIcons() {
        return this.icons;
    }

    public boolean isSelectedQuit() {
        return isSelected(this.text.size()-1);
    }
}
