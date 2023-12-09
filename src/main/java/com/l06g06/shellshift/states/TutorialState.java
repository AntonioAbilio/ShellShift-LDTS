package com.l06g06.shellshift.states;

import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.TutorialController;
import com.l06g06.shellshift.model.tutorial.TutorialMap;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.tutorial.TutorialViewer;

public class TutorialState extends State<TutorialMap>{
    public TutorialState(TutorialMap model) {
        super(model);
    }

    @Override
    protected View<TutorialMap> getViewer() {
        return new TutorialViewer(getModel());
    }

    @Override
    protected Controller<TutorialMap> getController() {
        return new TutorialController(getModel());
    }
}
