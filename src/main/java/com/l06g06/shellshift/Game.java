package com.l06g06.shellshift;

import com.l06g06.shellshift.gui.LanternaGUI;
import com.l06g06.shellshift.model.menus.MainMenu;
import com.l06g06.shellshift.states.MainMenuState;
import com.l06g06.shellshift.states.State;

import com.l06g06.shellshift.gui.Gui;

import java.io.IOException;

public class Game {
    private State state;
    private Gui gui;

    public Game() throws IOException {
         this.gui = new LanternaGUI(20,20);
         this.state = new MainMenuState(new MainMenu());
    }

    public static void main(String[] args) throws IOException{
        Game game = new Game();
        game.start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        while (true) {
            int FPS = 10;
            int frameTime = 1000 / FPS;

            long startTime = System.currentTimeMillis();

            state.step(this, gui);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
    }
}
