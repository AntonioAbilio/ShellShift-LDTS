package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Monster;

public class MonsterViewer implements ElementViewer<Monster>{
    @Override
    public void draw(Monster monster, Gui gui){
        gui.drawMonster(monster.getPosition());
    }
}
