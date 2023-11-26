package com.l06g06.shellshift.viewer.ranking;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.statistics.Statistics;
import com.l06g06.shellshift.viewer.View;

public class RankingViewer extends View<Statistics>{

    public RankingViewer(Statistics ranks){
        super(ranks);
    }

    @Override
    public void drawElements(Gui gui){
        gui.drawText(new Position(10,10), "Ranking", "#FFFFF");

        // Still need to figure out elements to add to the rankings ...

    }
}
