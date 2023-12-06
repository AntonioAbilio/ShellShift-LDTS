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
    boolean onCooldown = false;
    double elapsedTime = 0;
    double cooldownStartTime = 0;


    public PlatformController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {

        if (!onCooldown){
            onCooldown = true;
            cooldownStartTime = time;
            //System.out.println(onCooldown);
        }
        elapsedTime = (time - cooldownStartTime) / 1000.0;
        if (elapsedTime >= 0.1F){
            onCooldown = false;
            left_shift();
            //getModel().getPlatformSpawner().spawn(new Position(150, 50));
        }

        /*System.out.print("Elapsed time: ");
        System.out.println(elapsedTime);

        System.out.print("time_x: ");
        System.out.printf(String.valueOf(elapsedTime));*/
    }

    public void left_shift(){
        for (Platform platform : getModel().getPlatforms()){
            int x = platform.getPosition().getX();
            int y = platform.getPosition().getY();
            platform.setPosition(new Position(x - 1, y));
        }
    }
}
