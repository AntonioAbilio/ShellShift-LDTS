package com.l06g06.shellshift.viewer.game;

// Internelly we decided to call arena Map...
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.model.game.elements.Element;

import java.io.IOException;

public class GameViewer extends View<Map> {
    public GameViewer(Map map){
        super(map);
    }

    @Override
    public void drawElements(Gui gui) throws IOException {
        drawElements(gui, getModel().getWalls(), new PlatformViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElement(gui, getModel().getHero(), new ChellViewer());

        gui.drawText(new Position(0, 0), "Energy: " + getModel().().getEnergy(), "#");
    }

    private <T extends Element> void drawElements(Gui gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(Gui gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}
