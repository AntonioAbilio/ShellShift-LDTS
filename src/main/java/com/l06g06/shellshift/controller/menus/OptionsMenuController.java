package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.Sound;
import com.l06g06.shellshift.SoundsFx;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;
import com.l06g06.shellshift.states.MainMenuState;

import java.io.IOException;
import java.util.ArrayList;
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
                case DOWN:
                    getModel().nextOption();
                    break;
                case UP:
                    getModel().prevOption();
                    break;
                case LEFT:
                    if (getModel().isSelectedSoundSlider() && !getModel().isSoundOFF()) OptionsMenu.dencrementSound();
                    break;
                case RIGHT:
                    if (getModel().isSelectedSoundSlider() && !getModel().isSoundOFF()) OptionsMenu.incrementSound();
                    break;
                case SELECT:
                    Sound sound = Sound.getInstance();
                    sound.playSound(SoundsFx.OptionSelect);
                    if (getModel().isSelectedONorOFF()) {
                        getModel().setSoundOFF(!getModel().isSoundOFF());
                        List<Components> opts = new ArrayList<>(getModel().getOptions());
                        opts.removeIf(component -> component.equals(Components.SoundSliderButton));

                        if (getModel().isSoundOFF()) {
                            opts.remove(Components.SoundSliderButton);
                        } else {
                            opts.add(Components.SoundSliderButton);
                        }

                        getModel().setOptions(opts);
                    }
                    break;
                default:
            }
        }

    }
}
