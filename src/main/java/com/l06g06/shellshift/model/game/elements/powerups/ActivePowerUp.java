package com.l06g06.shellshift.model.game.elements.powerups;

import java.util.HashMap;
import java.util.Map;

public class ActivePowerUp {
    private final Map<String, Long> powerUpsAndDuration;

    public ActivePowerUp() {
        powerUpsAndDuration = new HashMap<>();
    }

    public void removePowerUp(String powerUp) {
        powerUpsAndDuration.remove(powerUp);
    }

    public long getDuration(String powerUp) {
        return powerUpsAndDuration.get(powerUp);
    }

    public void addOrUpdateActivePowerUp(String powerUp, Long duration) {
        powerUpsAndDuration.put(powerUp, duration);
    }

    public Map<String, Long> getPowerUpsAndDuration() {
        return powerUpsAndDuration;
    }
}

