package com.l06g06.shellshift.viewer.gameOver;

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
        gui.drawText(new Position(10,10), "GameOver!", "#FFFFF");
    }
}
