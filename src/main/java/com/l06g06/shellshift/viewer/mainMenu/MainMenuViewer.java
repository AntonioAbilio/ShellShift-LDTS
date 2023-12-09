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
        gui.setGradientBackground("#2F1E0D", "#110902");
        gui.drawImageASCII(Components.Title.getImage(), new Position(10,10));
        gui.drawImageASCII(Components.Chell.getImage(), new Position(130, 10));

        int i = 0;
        for (Components component : getModel().getOptions()) {
            gui.drawImageASCII(getModel().isSelected(i) ? component.getImageSelected() : component.getImage(), new Position(20,35 + i * 12));
            i++;
        }

    }
}
