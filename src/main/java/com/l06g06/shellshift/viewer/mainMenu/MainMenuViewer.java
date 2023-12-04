package com.l06g06.shellshift.viewer.mainMenu;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.viewer.View;

public class MainMenuViewer extends View<MainMenu> {

    public MainMenuViewer(MainMenu mainmenu) {
        super(mainmenu);
    }

    @Override
    public void drawElements(Gui gui){
        gui.drawText(new Position(5,2), "ShellShift", "#FFFFFF");
        int i = 0;
        for (String str : this.getModel().getOptions()){
            gui.drawText(new Position(5,5+i), str, getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
            i++;
        }
    }
}
