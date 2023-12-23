package com.l06g06.shellshift.model.gameOver;

import com.l06g06.shellshift.Components;

import java.util.Arrays;
import java.util.List;

public class GameOver{
    private List<Components> options;
    private int currOption = 0;
    public GameOver() {
        this.options = Arrays.asList(Components.Restart, Components.MainMenu);
    }
    public void prevOption() {
        currOption--;
        if (currOption < 0)
            currOption = 0;
    }
    public void nextOption() {
        currOption++;
        if (currOption > this.options.size() - 1)
            currOption = this.options.size() - 1;
    }

    public boolean isSelected(int i) {
        return i == currOption;
    }

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public List<Components> getOptions() {
        return this.options;
    }

    public boolean isSelectedMainMenu() {
        return isSelected(1);
    }
}
