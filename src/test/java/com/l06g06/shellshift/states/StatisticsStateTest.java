package com.l06g06.shellshift.states;

import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.StatisticsController;
import com.l06g06.shellshift.model.statistics.Statistics;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.statistics.StatisticsViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StatisticsStateTest {
    private Statistics statistics;
    private StatisticsState statisticsState;

    @BeforeEach
    void setup(){
        statistics = Mockito.mock(Statistics.class);
        statisticsState = new StatisticsState(statistics);
    }

    @Test
    void getViewerTest(){
        View<Statistics> viewer = statisticsState.getViewer();
        Assertions.assertEquals(StatisticsViewer.class, viewer.getClass());
    }

    @Test
    void getControllerTest(){
        Controller<Statistics> controller = statisticsState.getController();
        Assertions.assertEquals(StatisticsController.class, controller.getClass());
    }
}
