package com.l06g06.shellshift.viewer.mainMenu;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.viewer.View;

public class MainMenuViewer extends View<MainMenu> {

    public MainMenuViewer(MainMenu mainMenu) {
        super(mainMenu);
    }
    @Override
    public void drawElements(Gui gui){
        //gui.setGradientBackground("#2F1E0D", "#110902");
        gui.setGradientBackground("#ABF0F9", "#457da8");
        //gui.setBackground("#8ec4e8");


        gui.drawImageASCII(Components.Title.getImage(), new Position(25,10));
        gui.drawImageASCII(Components.Chell.getImage(), new Position(100, 60));
        gui.drawImageASCII(Components.Cloud.getImage(), new Position(95, 40));
        gui.drawImageASCII(Components.Cloud.getImage(), new Position(120, 55));
        gui.drawImageASCII(Components.Platform.getImageSelected(), new Position(90, 75));

        int i = 0;
        for (Components component : getModel().getOptions()) {
            gui.drawImageASCII(getModel().isSelected(i) ? component.getImageSelected() : component.getImage(), new Position(15,35 + i * 12));
            i++;
        }

    }
}
