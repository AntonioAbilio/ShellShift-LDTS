package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.controller.game.elements.PlatformController;
import com.l06g06.shellshift.model.creators.PlatformCreator;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;

import java.util.List;

public class PlatformSpawner {
    private int i = 0;
    private PlatformCreator platformCreator;
    private List<Platform> platforms;

    public PlatformSpawner(List<Platform> platforms){
        this.platforms = platforms;
        this.platformCreator = new PlatformCreator();
    }

    public void spawn(Position position){
        Platform spawned_platform = (Platform) platformCreator.create(position);
        platforms.add(spawned_platform);
        if (i >= 3) {
            i = 3;
            platforms.remove(0);
        }
        else{
            i++;
        }
    }

    // Not complete
    /*static Map createMap(int x, int y){
        createEntities();
        return new Map(x,y);
    }

    private static void createEntities(){}*/
}
