package com.l06g06.shellshift.model.optionsMenu;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionsMenu {
    private List<Components> options;
    public static boolean soundOFF = Database.getInstance().isSoundIsOn();;
    int currOption = 0;

    static int soundSliderX = Database.getInstance().getSoundSliderX();
    static float soundSliderValue = Database.getInstance().getSoundVolume();

    public OptionsMenu() {
        this.options = Arrays.asList(Components.SoundON, Components.SoundSliderButton);
        if (isSoundOFF()){
            List<Components> opts = new ArrayList<>(getOptions());
            opts.removeIf(component -> component.equals(Components.SoundSliderButton));
            setOptions(opts);
        }
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

    public static void incrementSound(){
        if (soundSliderValue >= -14F){
            soundSliderValue = -14F;
            soundSliderX = 115;
        } else {
            soundSliderValue += 1.3F;
            soundSliderX += 1;
        }
        Database.getInstance().setSoundVolume(soundSliderValue);
        Database.getInstance().setSoundSliderX(soundSliderX);
    }
    public static void dencrementSound(){
        if (soundSliderValue <= -60F){
            soundSliderValue = -60F;
            soundSliderX = 78;
        } else {
            soundSliderValue -= 1.3F;
            soundSliderX -= 1;
        }
        Database.getInstance().setSoundVolume(soundSliderValue);
        Database.getInstance().setSoundSliderX(soundSliderX);
    }

    public static float getSoundSliderValue() {
        return soundSliderValue;
    }

    public static int getSoundSliderX() {
        return soundSliderX;
    }

    public int getCurrOption() { return currOption; }
    public boolean isSelected(int i) {
        return i == currOption;
    }



    public List<Components> getOptions(){
        return options;
    }

    public void setOptions(List<Components> opts){
        this.options = opts;
    }

    public int getOptionsSize() {
        return this.options.size();
    }

    public boolean isSoundOFF() {
        return soundOFF;
    }

    public boolean isSelectedONorOFF(){
        return isSelected(0);
    }

    public boolean isSelectedSoundSlider(){
        return (isSelected(options.size()-1) && !OptionsMenu.soundOFF);
    }

    public void setSoundOFF(boolean soundState){
        soundOFF = soundState;
        Database database = Database.getInstance();
        database.setSound(soundState);
    }

}
