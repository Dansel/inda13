package com.me.Javaga.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.gamestate.*;

/**
 * Keeps track of the gamestate (play, pause etc) as well as updates subclasses.
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

        menu = new MenuState(this);
        play = new PlayState(this);
        pause = new PauseState(this);
        welcome = new WelcomeState(this);

        setState(WELCOME);
        MusicManeger.startNewSong(MusicManeger.PLAYSONG);
    }

	/**
	 * Sets the gamestate.
	 * @param state int number correlating a specific state. 0 = menu, 1= play, 2=pause, 3 = welcome screen
	 */
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

	/**
	 * Updates the game.
	 */
    public void update() {
        currentGameState.update();
    }


	/**
	 * Draws the entire canvas.
	 * @param batch SpriteBatch containing a collection of sprites.
	 */
    public void draw(SpriteBatch batch) {
        currentGameState.draw(batch);
    }
}
