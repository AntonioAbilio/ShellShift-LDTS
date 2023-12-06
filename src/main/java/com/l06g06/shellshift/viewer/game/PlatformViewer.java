package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.viewer.View;

public class PlatformViewer implements ElementViewer<Platform>{

    public static final String[] PLATFORM = {
            "JJJJJJJJJJJJJJJJ",
            "MNOPPPPPPPPPPONM",
            "MNOPPPPPPPPPPONM",
            "JJJJJJJJJJJJJJJJ"
    };

    @Override
    public void draw(Platform platform, Gui gui){
        View.ASCII_Drawer(PLATFORM, platform.getPosition(), gui);
        //gui.drawPlatform(platform.getPosition());
    }
}
