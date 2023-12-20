package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.Sound;
import com.l06g06.shellshift.SoundsFx;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;
import com.l06g06.shellshift.states.MainMenuState;

import java.io.IOException;
import java.util.List;

public class OptionsMenuController extends Controller<OptionsMenu> {
    public OptionsMenuController(OptionsMenu model) {
        super(model);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        for (Gui.PressedKey gpk : action) {
            Game.sleepTimeMS(100);

            switch (gpk) {
                case EXIT:
                    game.setState(new MainMenuState(new MainMenu()));
                    break;
                case SELECT:
                    //SomAqui Sound.playSound(SoundsFx.OptionSelect);
                    Sound sound = Sound.getInstance();
                    sound.playSound(SoundsFx.OptionSelect);
                    if (getModel().isSoundOFF()){
                        getModel().setSound(false);
                    } else {
                        getModel().setSound(true);
                    }
                    break;
                default:
            }
        }

    }
}
