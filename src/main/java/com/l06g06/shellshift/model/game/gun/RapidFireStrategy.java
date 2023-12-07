package com.l06g06.shellshift.model.game.gun;

public class RapidFireStrategy implements FireStrategy{
    @Override
    public double getReloadTime() {
        return 300;
    }
}
