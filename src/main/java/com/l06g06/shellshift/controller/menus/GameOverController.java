package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.gameOver.GameOver;

import java.io.IOException;
import java.util.List;

public class GameOverController extends Controller<GameOver> {

    public GameOverController(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        // ToDo
    }

}
