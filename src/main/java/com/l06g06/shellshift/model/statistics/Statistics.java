package com.l06g06.shellshift.model.statistics;

import java.util.Arrays;
import java.util.List;

public class Statistics{
    private List<String> options;
    private int currOption = 0;
    public Statistics() {
        this.options = Arrays.asList("Main Menu");
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
        return isSelected(0);
    }
}
