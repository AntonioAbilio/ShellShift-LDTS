package com.l06g06.shellshift;

public enum SoundsFx {
    Coin("sounds/coin.wav"),
    PowerUP("sounds/powerup.wav"),
    Death("sounds/death.wav"),
    MonsterCollision("sounds/hurt.wav"),
    Jump("sounds/jump.wav"),
    BulletFired("sounds/fire.wav"),
    OptionSelect("sounds/select.wav");

    private final String path;

    SoundsFx(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}