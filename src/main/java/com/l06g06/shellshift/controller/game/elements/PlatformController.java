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
    double lastSpawnTime = 0;
    double lastShiftTime = 0;
    //int acceleration;


    public PlatformController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {

        double currentTime = time / 1000.0; // Convert to seconds

        // Spawn platforms logic
        if (currentTime - lastSpawnTime >= MapController.getSpawnCooldown()){
            lastSpawnTime = currentTime;
            getModel().getPlatformSpawner().spawn(new Position(230, getModel().getChell().getPosition().getY()));
        }

        // Shift platforms logic
        if (currentTime - lastShiftTime >= MapController.getShiftCooldown()){
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

    /*public void updateAcceleration(long elapsedTimeSinceGameStart){
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
    }*/

}
