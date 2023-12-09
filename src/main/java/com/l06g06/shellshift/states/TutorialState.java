package com.l06g06.shellshift.states;

import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.TutorialController;
import com.l06g06.shellshift.model.tutorial.Tutorial;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.tutorial.TutorialViewer;

public class TutorialState extends State<Tutorial>{
    public TutorialState(Tutorial model) {
        super(model);
    }

    @Override
    protected View<Tutorial> getViewer() {
        return new TutorialViewer(getModel());
    }

    @Override
    protected Controller<Tutorial> getController() {
        return new TutorialController(getModel());
    }
}
