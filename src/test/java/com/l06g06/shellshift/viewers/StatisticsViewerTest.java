package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.statistics.Statistics;
import com.l06g06.shellshift.viewer.statistics.StatisticsViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class StatisticsViewerTest {
    private Statistics stats;
    private StatisticsViewer viewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        stats = Mockito.mock(Statistics.class);
        viewer = new StatisticsViewer(stats);
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawStatistics() {
        /*
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
         */
        viewer.drawElements(gui);


    }
}
