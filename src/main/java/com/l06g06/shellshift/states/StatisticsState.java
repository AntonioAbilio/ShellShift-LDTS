package com.l06g06.shellshift.states;

import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.StatisticsController;
import com.l06g06.shellshift.model.statistics.Statistics;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.statistics.StatisticsViewer;

public class StatisticsState extends State<Statistics>{
    public StatisticsState(Statistics model) {
        super(model);
    }

    @Override
    protected View<Statistics> getViewer() {
        return new StatisticsViewer(getModel());
    }

    @Override
    protected Controller<Statistics> getController() {
        return new StatisticsController(getModel());
    }
}
