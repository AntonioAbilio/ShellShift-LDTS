package com.l06g06.shellshift.controller.game.elements;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;

import java.io.IOException;
import java.util.List;

public class PlatformController extends GameController {
    double spawnCooldown = 3; // Spawn every 3 seconds
    double shiftCooldown = 0.1; // Shift every 0.1 seconds
    double lastSpawnTime = 0;
    double lastShiftTime = 0;

    public PlatformController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {


        double currentTime = time / 1000.0; // Convert to seconds

        // Spawn platforms logic
        if (currentTime - lastSpawnTime >= spawnCooldown){
            lastSpawnTime = currentTime;
            getModel().getPlatformSpawner().spawn(new Position(230, getModel().getChell().getPosition().getY()));
        }

        // Shift platforms logic
        if (currentTime - lastShiftTime >= shiftCooldown){
            lastShiftTime = currentTime;
            left_shift();
        }

    }

    public void left_shift(){
        for (Platform platform : getModel().getPlatforms()){
            int x = platform.getPosition().getX();
            int y = platform.getPosition().getY();
            platform.setPosition(new Position(x - 1, y));
        }
    }
}
