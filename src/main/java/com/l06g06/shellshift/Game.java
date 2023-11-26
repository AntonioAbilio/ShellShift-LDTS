package com.l06g06.shellshift;

import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.states.MainMenuState;
import com.l06g06.shellshift.states.State;

import java.io.IOException;

public class Game {
    private State state;

    public Game() {
        // this.gui = new Lanterna();
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
        int i = 0;
        while (i <= 5) {
            state.step(this);
            i++;
        }
    }
}
