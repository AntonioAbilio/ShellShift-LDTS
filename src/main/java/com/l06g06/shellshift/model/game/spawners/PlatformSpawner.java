package com.l06g06.shellshift.model.game.spawners;

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

        //esta logica tem q ser passada po create -> guardar nivel onde criou ultima e dps mete noutro diferente
        Iterator<Platform> platformIterator = platforms.iterator();
        while(platformIterator.hasNext()){
            Platform platform = platformIterator.next();
            while (spawned_platform.getPolygon().intersects(platform.getPolygon().getBounds2D())) {
                spawned_platform = (Platform) platformCreator.create(position);
            }
        }

        platforms.add(spawned_platform);
        platforms.removeIf(platform -> platform.getPosition().getX() <= 0);
    }

    // Not complete
    /*static Map createMap(int x, int y){
        createEntities();
        return new Map(x,y);
    }

    private static void createEntities(){}*/
}
