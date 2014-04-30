package com.me.Javaga.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.gamestate.*;

/**
 * Created by Dansel on 2014-04-30.
 */
public class GameStateManager {
    private GameState currentGameState;

    private MenuState menu;
    private PlayState play;
    private PauseState pause;
    private WelcomeState welcome;

    public static final int MENU = 0;
    public static final int PLAY = 1;
    public static final int PAUSE = 2;
    public static final int WELCOME = 3;

    public GameStateManager() {

        menu = new MenuState();
        play = new PlayState();
        pause = new PauseState();
        welcome = new WelcomeState();

        setState(WELCOME);
    }

    public void setState(int state){
        if (state == MENU) {
            currentGameState = menu;
        }
        if(state == PLAY) {
            currentGameState = play;
        }
        if (state == PAUSE) {
            currentGameState = pause;
        }
        if (state == WELCOME) {
            currentGameState = welcome;
        }

    }


    public void update() {
        currentGameState.update();
    }

    public void draw(SpriteBatch batch) {
        currentGameState.draw(batch);
    }
}
