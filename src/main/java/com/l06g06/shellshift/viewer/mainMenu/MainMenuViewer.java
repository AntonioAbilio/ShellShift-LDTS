package com.l06g06.shellshift.viewer.mainMenu;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.mainMenu.MainMenu;
import com.l06g06.shellshift.viewer.View;

public class MainMenuViewer extends View<MainMenu> {

    public MainMenuViewer(MainMenu mainmenu) {
        super(mainmenu);
    }

    @Override
    public void drawElements(Gui gui){
        gui.drawText(new Position(10,10), "ShellShift", "#FFFFFF");

        // No elements present in mainMenu yet...
    }
}
