package com.l06g06.shellshift.model.game.spawners;

import com.l06g06.shellshift.model.creators.CloudCreator;
import com.l06g06.shellshift.model.game.elements.Cloud;
import com.l06g06.shellshift.model.game.elements.Position;

import java.util.List;

public class CloudSpawner {
    private final CloudCreator cloudCreator;
    private final List<Cloud> clouds;

    public CloudSpawner(List<Cloud> clouds) {
        this.clouds = clouds;
        this.cloudCreator = new CloudCreator();
    }

    public void spawn(Position position) {
        Cloud cloudSpawned = (Cloud) cloudCreator.create(position);
        this.clouds.add(cloudSpawned);

        this.clouds.removeIf(cloud -> cloud.getPosition().getX() < -50);
    }
}
