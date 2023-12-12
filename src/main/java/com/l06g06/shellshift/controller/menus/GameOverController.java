package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.Sound;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.states.GameState;
import com.l06g06.shellshift.states.MainMenuState;

import java.io.IOException;
import java.util.List;

public class GameOverController extends Controller<GameOver> {

    public GameOverController(GameOver gameOver) {
        super(gameOver);
        Sound.playSound(Sound.SoundsFx.Death);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        //funciona como um controller de menu basicamente, duas opcoes restart e main menu
        for (Gui.PressedKey gpk : action) {
            switch (gpk) {
                case UP:
                    getModel().prevOption();
                    break;
                case DOWN:
                    getModel().nextOption();
                    break;
                case SELECT:
                    Sound.playSound(Sound.SoundsFx.OptionSelect);
                    if (getModel().isSelectedRestart()) game.setState(new GameState(new Map(165,100)));
                    if (getModel().isSelectedMainMenu()) game.setState(new MainMenuState(new MainMenu()));
                    break;
            }
            Game.sleepTimeMS(100); // isto aqui e so para os inputs nao serem tao sensiveis
        }
    }

}
