package com.l06g06.shellshift.controller.menus;


import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.statistics.Statistics;

import java.io.IOException;

public class StatisticsController extends Controller<Statistics> {

    public StatisticsController(Statistics statistics) {
        super(statistics);
    }

    @Override
    public void step(Game game, Gui.PressedKey action, long time) throws IOException {
        // ToDo
    }

}
