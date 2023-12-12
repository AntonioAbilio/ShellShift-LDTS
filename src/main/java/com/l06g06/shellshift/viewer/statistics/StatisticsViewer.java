package com.l06g06.shellshift.viewer.statistics;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.statistics.Statistics;
import com.l06g06.shellshift.viewer.View;
import jdk.jfr.DataAmount;

import java.util.List;

public class StatisticsViewer extends View<Statistics> {
    public StatisticsViewer(Statistics model) {
        super(model);
    }

    @Override
    public void drawElements(Gui gui) {
        gui.setGradientBackground("#ABF0F9", "#457da8");
        gui.drawImageASCII(Components.Highscores.getImage(), new Position(8,10));

        List<Integer> scores = Database.getInstance().getScores();
        for (int i = 0; i < scores.size(); i++) {
            gui.drawImageASCII(Components.getOrdinalNumbers().get(i).getImage(), new Position(10,25 + i * 10));
            gui.numToASCII(scores.get(i), 30, 25 + i * 10);
        }

        gui.drawImageASCII(Components.MonstersKilled.getImage(), new Position(8, 58));
        gui.numToASCII(Database.getInstance().getMonstersKilled(), 110, 60);

        gui.drawImageASCII(Components.NumLives.getImage(), new Position(8, 70));
        gui.numToASCII(Database.getInstance().getNumLives(), 45, 72);

        gui.drawImageASCII(Components.CoinsCollected.getImage(), new Position(8, 83));
        gui.numToASCII(Database.getInstance().getCollectedCoins(), 110 ,85);

        //gui.numToASCII(Database.getInstance().getMonstersKilled(), 50,50);
        //gui.numToASCII(Database.getInstance().getNumLives(), 50,50);

    }
}
