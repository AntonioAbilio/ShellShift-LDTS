package com.l06g06.shellshift.model.optionsMenu;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.List;

public class OptionsMenu {
    private final List<Components> options;
    public static boolean soundOFF = Database.getInstance().isSoundIsOn();;

    public OptionsMenu() {
        this.options = Arrays.asList(Components.SoundON, Components.SoundOFF);
    }

    public List<Components> getOptions(){
        return options;
    }

    public int getOptionsSize() {
        return this.options.size();
    }

    public boolean isSoundOFF() {
        return soundOFF;
    }

    public void setSound(boolean soundState){
        soundOFF = soundState;
        Database database = Database.getInstance();
        database.setSound(soundState);
    }

}
