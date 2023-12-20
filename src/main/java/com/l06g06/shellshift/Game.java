package com.l06g06.shellshift;

import com.l06g06.shellshift.gui.ListenForKeys;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.gui.LanternaGUI;
import com.l06g06.shellshift.states.MainMenuState;
import com.l06g06.shellshift.states.State;

import java.awt.*;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private State state;
    private final LanternaGUI gui;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(160, 100);
        this.state = new MainMenuState(new MainMenu());
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
 /*       try {*/
            new Game().start();
        /*} catch (Exception e){
            e.printStackTrace();
        }*/
    }

    public static void sleepTimeMS(long miliseconds){
        try{
            Thread.sleep(miliseconds);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    @SuppressWarnings("unused")
    private void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;
        KeyListener keysListen = new ListenForKeys(this.gui);
        Sound sound = Sound.getInstance();

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) sleepTimeMS(sleepTime);
        }

        gui.close();
    }

}
