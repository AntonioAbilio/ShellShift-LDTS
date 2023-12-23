package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.statistics.Statistics;
import com.l06g06.shellshift.viewer.statistics.StatisticsViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class StatisticsViewerTest {
    private Statistics stats;
    private StatisticsViewer viewer;
    private Gui gui;
    private Database database;

    @BeforeEach
    void setUp(){
        stats = Mockito.mock(Statistics.class);
        viewer = new StatisticsViewer(stats);
        gui = Mockito.mock(Gui.class);
        Database.setInstance(database);
        database = Database.getInstance();
        database.setSound(true);
    }

    @Test
    void drawStatistics() {
        viewer.drawElements(gui);
        verify(gui, times(1)).setGradientBackground(anyString(), anyString());
        verify(gui, times(1)).drawImageASCII(eq(Components.Highscores.getImage()), any(Position.class));

        for (int i = 0; i < 3; i++) {
            verify(gui, times(1)).numToASCII(anyInt(), eq(30), eq(25 + i * 10));
        }
        int i = 0;
        verify(gui, times(1)).drawImageASCII(any(), eq(new Position(10, 25 + i++ * 10)));
        verify(gui, times(1)).drawImageASCII(any(), eq(new Position(10, 25 + i++ * 10)));
        verify(gui, times(1)).drawImageASCII(any(), eq(new Position(10, 25 + i * 10)));


        verify(gui, times(1)).drawImageASCII(eq(Components.MonstersKilled.getImage()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.NumLives.getImage()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.CoinsCollected.getImage()), any(Position.class));

        verify(gui, times(6)).numToASCII(anyInt(),anyInt(),anyInt());
    }

}
