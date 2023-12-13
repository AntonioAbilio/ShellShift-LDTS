package com.l06g06.shellshift.states;

import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.StatisticsController;
import com.l06g06.shellshift.model.statistics.Statistics;
import com.l06g06.shellshift.viewer.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StatisticsStateTest {
    private Statistics statistics;
    private StatisticsState rankingState;

    @BeforeEach
    void setup(){
        statistics = Mockito.mock(Statistics.class);
        rankingState = new StatisticsState(statistics);
    }

    @Test
    void getViewerTest(){
        View<Statistics> viewer = rankingState.getViewer();

        Assertions.assertEquals(StatisticsState.class, viewer.getClass());

    }

    @Test
    void getControllerTest(){
        Controller<Statistics> controller = rankingState.getController();

        Assertions.assertEquals(StatisticsController.class, controller.getClass());
    }
}
