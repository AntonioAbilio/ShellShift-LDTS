package com.l06g06.shellshift.states;

import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.mainMenu.MainMenuViewer;

public class MainMenuState extends State<MainMenu>{
    public MainMenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected View<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }
}
