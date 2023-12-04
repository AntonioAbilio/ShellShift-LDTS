package com.l06g06.shellshift.states;

import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.GameOverController;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.gameOver.GameOverViewer;
import com.l06g06.shellshift.model.gameOver.GameOver;

public class GameOverState extends State<GameOver> {

    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected View<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
