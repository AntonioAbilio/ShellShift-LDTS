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

        try {
            viewer.drawTest(gui);
            // Extra info: Commented because method does not exist anymore.
            //Mockito.verify(gui, Mockito.times(1)).drawText(Mockito.any(Position.class), Mockito.eq("Ranking"), Mockito.eq("#FFFFF"));
        } catch (IOException ioe) {
            fail("Caught the IOException: " + ioe.getMessage());
        }

    }
}
