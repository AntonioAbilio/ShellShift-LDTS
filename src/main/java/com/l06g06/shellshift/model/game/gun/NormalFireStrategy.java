package com.l06g06.shellshift.model.game.gun;

public class NormalFireStrategy implements FireStrategy{

    @Override
    public double getReloadTime() {
        return 1000;
    }
}
