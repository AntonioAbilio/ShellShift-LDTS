package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.creators.PlatformCreator;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;

import java.util.Iterator;
import java.util.List;

public class PlatformSpawner {
    private PlatformCreator platformCreator;
    private List<Platform> platforms;

    public PlatformSpawner(List<Platform> platforms){
        this.platforms = platforms;
        this.platformCreator = new PlatformCreator();
    }

    public void spawn(Position position){
        Platform spawned_platform = (Platform) platformCreator.create(position);

        platforms.add(spawned_platform);
        for (int i = 0; i < platforms.size(); i++){
            if (platforms.get(i).getPosition().getX() <= 0) platforms.remove(i);
        }
    }
}
