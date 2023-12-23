package com.l06g06.shellshift.controller.game.elements;

import com.google.common.annotations.VisibleForTesting;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.map.Map;

import java.util.ArrayList;
import java.util.List;

public class ActivePowerUpController extends GameController {
    private long lastTimeCalled;

    public ActivePowerUpController(Map map) {
        super(map);
        lastTimeCalled = System.currentTimeMillis();
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {
        if (time - lastTimeCalled >= 1000) {
            List<String> toBeRemoved = new ArrayList<>();

            for (String powerUp : getModel().getActivePowerUp().getPowerUpsAndDuration().keySet()) {
                long currentDuration = getModel().getActivePowerUp().getDuration(powerUp);

                if (currentDuration <= 1000) {
                    toBeRemoved.add(powerUp);
                } else {
                    getModel().getActivePowerUp().addOrUpdateActivePowerUp(powerUp, currentDuration - 1000);
                }
            }

            for (String powerUp : toBeRemoved) {
                getModel().getActivePowerUp().removePowerUp(powerUp);
            }

            lastTimeCalled = time;
        }
    }

    @VisibleForTesting
    public void setLastTimeCalled(long time) {
        lastTimeCalled = time;
    }

}
