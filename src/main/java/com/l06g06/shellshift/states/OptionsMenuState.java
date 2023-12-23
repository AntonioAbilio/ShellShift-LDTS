package com.l06g06.shellshift.states;

import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.OptionsMenuController;
import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.optionsMenu.OptionsMenuViewer;

public class OptionsMenuState extends State<OptionsMenu> {

    public OptionsMenuState(OptionsMenu model) {
        super(model);
    }

    @Override
    protected View<OptionsMenu> getViewer() {
        return new OptionsMenuViewer(getModel());
    }

    @Override
    protected Controller<OptionsMenu> getController() {
        return new OptionsMenuController(getModel());
    }
}
