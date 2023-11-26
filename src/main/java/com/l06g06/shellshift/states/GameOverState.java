package com.l06g06.shellshift.states;

import com.l06g06.shellshift.model.menus.GameOverMenu;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.game.GameViewer;
import com.l06g06.shellshift.viewer.gameOver.GameOverViewer;

public class GameOverState extends State<GameOverMenu> {

    public GameOverState(GameOverMenu model) {
        super(model);
    }

    @Override
    protected View<GameOverMenu> getViewer() {
        return new GameOverViewer(getModel());
    }
}
