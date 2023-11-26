package com.l06g06.shellshift.states;

import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.game.GameViewer;

public class GameState extends State<Map>{
    public GameState(Map model) {
        super(model);
    }

    @Override
    protected View<Map> getViewer() {
        return new GameViewer(getModel());
    }
}
