package com.l06g06.shellshift.states;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.controller.game.MapController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.game.GameViewer;

import java.io.IOException;

public class GameState extends State<Map> {
    public GameState(Map model) {
        super(model);
    }

    @Override
    protected View<Map> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new MapController(getModel());
    }
}
