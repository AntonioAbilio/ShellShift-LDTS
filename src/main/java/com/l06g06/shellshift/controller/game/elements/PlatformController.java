package com.l06g06.shellshift.controller.game.elements;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.controller.game.MapController;
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
    int acceleration;
    boolean updated1 = false;
    boolean updated2 = false;

    public PlatformController(Map map) {
        super(map);
        acceleration = 1;
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {

        long elapsedTimeSinceGameStart =  (time - MapController.getGameStartTime()) / 1000;

        updateAcceleration(elapsedTimeSinceGameStart);

        double currentTime = time / 1000.0; // Convert to seconds

        // Spawn platforms logic
        if (currentTime - lastSpawnTime >= spawnCooldown){
            lastSpawnTime = currentTime;
            getModel().getPlatformSpawner().spawn(new Position(110, getModel().getChell().getPosition().getY()));
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
            platform.setPosition(new Position(x - acceleration, y));
        }
    }

    public void updateAcceleration(long elapsedTimeSinceGameStart){
        // Acceleration is divided in 3 levels
        if (!updated1 && elapsedTimeSinceGameStart >= 30){
            updated1 = true;
            acceleration++;
            System.out.println("30 seconds passed (Acceleration level 2)");
        } else if (!updated2 && elapsedTimeSinceGameStart >= 120){
            updated2 = true;
            acceleration++;
            System.out.println("120 seconds passed (Acceleration level 3)");
        }
    }

}
