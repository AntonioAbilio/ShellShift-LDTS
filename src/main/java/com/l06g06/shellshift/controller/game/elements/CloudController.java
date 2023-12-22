package com.l06g06.shellshift.controller.game.elements;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.controller.game.MapController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Cloud;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CloudController extends GameController {
    private double lastShiftTime = 0;
    private double lastSpawnTime = 0;

    public CloudController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        double currentTime = time / 1000.0; // Convert to seconds

        if (currentTime - lastShiftTime >= getModel().getShiftCooldown() + 0.15){
            lastShiftTime = currentTime;
            left_shift();
        }

        if (currentTime - lastSpawnTime >= getModel().getSpawnCooldown() + 15){
            lastSpawnTime = currentTime;
            spawn();
        }


    }

    private void spawn() {
        getModel().getCloudSpawner().spawn(new Position(200,40));
        System.out.println(getModel().getClouds().size());
    }

    public void left_shift(){
        for (Cloud c : getModel().getClouds()) {
            c.setPosition(new Position(c.getPosition().getX()-1, c.getPosition().getY()));
        }
    }
}
