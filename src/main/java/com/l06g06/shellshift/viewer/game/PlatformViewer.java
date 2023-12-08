package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.viewer.View;

public class PlatformViewer implements ElementViewer<Platform>{

    public static final String[] PLATFORM = {
            "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ",
            "MNOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPONM",
            "MNOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPONM",
            "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ"
    };

    /*private static final String[] HITBOX = new String[]{
            "P"
    };*/

    @Override
    public void draw(Platform platform, Gui gui){
        /*View.ASCII_Drawer(PLATFORM, platform.getPosition(), gui);
        //Uncomment this to see hithox.
        for (int i = 0; i < platform.getPolygon().npoints; i++) {
            int x = platform.getPolygon().xpoints[i];
            int y = platform.getPolygon().ypoints[i];
            View.ASCII_Drawer(HITBOX, new Position(x,y), gui);
            *//*System.out.println("Vertex " + (i + 1) + ": (" + x + ", " + y + ")");*//*
        }*/
        gui.drawImageASCII(PLATFORM, platform.getPosition());
        //gui.drawPlatform(platform.getPosition());
    }
}
