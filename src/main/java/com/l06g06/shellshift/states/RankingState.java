package com.l06g06.shellshift.states;

import com.l06g06.shellshift.model.menus.RankingMenu;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.ranking.RankingViewer;

public class RankingState extends State<RankingMenu> {
    public RankingState(RankingMenu model) {
        super(model);
    }

    @Override
    protected View<RankingMenu> getViewer() {
        return new RankingViewer(getModel());
    }
}
