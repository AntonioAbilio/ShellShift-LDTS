package com.l06g06.shellshift.viewer.ranking;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.menus.*;
import com.l06g06.shellshift.viewer.View;

public class RankingViewer extends View<RankingMenu>{

    public RankingViewer(RankingMenu ranks){
        super(ranks);
    }

    @Override
    public void drawElements(Gui gui){
        gui.drawText(new Position(10,10), "Ranking", "#FFFFF");

        // Still need to figure out elements to add to the rankings ...

    }
}
