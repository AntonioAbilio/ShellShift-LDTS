package com.l06g06.shellshift.states;

import com.l06g06.shellshift.model.statistics.Statistics;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.ranking.RankingViewer;

public class RankingState extends State<Statistics> {
    public RankingState(Statistics model) {
        super(model);
    }

    @Override
    protected View<Statistics> getViewer() {
        return new RankingViewer(getModel());
    }
}
