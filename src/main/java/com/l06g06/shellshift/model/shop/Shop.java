package com.l06g06.shellshift.model.shop;

import com.l06g06.shellshift.Components;

import java.util.*;

public class Shop {
    private final Map<Components, Integer> options = new LinkedHashMap<>();
    private final List<Components> icons;
    private int currOption = 0;

    public Shop() {
        this.options.put(Components.RapidFire, 50);
        this.options.put(Components.ExtraLife, 20);
        this.options.put(Components.MoreBullets, 10);
        this.icons = Arrays.asList(Components.RapidFireIcon ,Components.HeartIcon, Components.MoreBulletsIcon);
    }

    public void nextOption() {
        currOption++;
        if (currOption > this.options.size() - 1)
            currOption = this.options.size() - 1;
    }

    public void prevOption() {
        currOption--;
        if (currOption < 0)
            currOption = 0;
    }


    public boolean isSelected(int i) {
        return i == currOption;
    }
    public int getPrice(Components component) {
        return options.get(component);
    }
    public boolean isSelectedRapidFire() {
        return isSelected(0);
    }

    public boolean isSelectedExtraLife() {
        return isSelected(1);
    }

    public Map<Components, Integer> getOptions() {
        return this.options;
    }

    public List<Components> getIcons() {
        return this.icons;
    }

    public boolean isSelectedQuit() {
        return isSelected(this.options.size()-1);
    }

    public boolean isSelectedMoreBullets() {
        return isSelected(2);
    }


}
