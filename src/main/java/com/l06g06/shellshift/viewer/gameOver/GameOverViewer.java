package com.l06g06.shellshift.viewer.gameOver;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.viewer.View;

public class GameOverViewer extends View<GameOver> {

    public GameOverViewer(GameOver gameover) {
        super(gameover);
    }

    @Override
    public void drawElements(Gui gui){
        gui.drawImageASCII(Components.GameOver.getImage(), new Position(25, 10));

        int i = 0;
        for (Components component : getModel().getOptions()) {
            gui.drawImageASCII(getModel().isSelected(i) ? component.getImageSelected() : component.getImage(), new Position(15, 45 + i * 12));
            i++;
        }
    }
}
