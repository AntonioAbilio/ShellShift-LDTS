package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Platform;

public class PlatformViewer implements ElementViewer<Platform>{
    @Override
    public void draw(Platform platform, Gui gui){
        gui.drawPlatform(platform.getPosition());
    }
}
