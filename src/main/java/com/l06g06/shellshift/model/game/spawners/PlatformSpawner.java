package com.l06g06.shellshift.model.game.spawners;

import com.l06g06.shellshift.model.creators.PlatformCreator;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;

import java.util.List;

public class PlatformSpawner {
    private final PlatformCreator platformCreator;
    private final List<Platform> platforms;

    public PlatformSpawner(List<Platform> platforms) {
        this.platforms = platforms;
        this.platformCreator = new PlatformCreator();
    }

    public void spawn(Position position) {
        Platform spawned_platform = (Platform) platformCreator.create(position);
        platforms.add(spawned_platform);
        platforms.removeIf(platform -> platform.getPosition().getX() <= 0);
    }
}
