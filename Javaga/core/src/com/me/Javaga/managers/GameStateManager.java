package com.me.Javaga.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.gamestate.*;

/**
 * Keeps track of the gamestate (play, pause etc) as well as updates subclasses.
 * Created by Dansel on 2014-04-30.
 */
public class GameStateManager {
	public static final int MENU = 0;
	public static final int PLAY = 1;
	public static final int PAUSE = 2;
	public static final int WELCOME = 3;
	private static float musicVolume;
	private static float effectVolume;
	private GameState currentGameState;
	private MenuState menu;
	private PlayState play;
	private PauseState pause;
	private WelcomeState welcome;

	public GameStateManager() {

		menu = new MenuState(this);
		play = new PlayState(this);
		pause = new PauseState(this);
		welcome = new WelcomeState(this);

		setMusicVolume(1f);
		setEffectVolume(0.3f);
		setState(WELCOME, false);
		MusicManager.startNewSong(MusicManager.WELCOMESONG);
	}

	/**
	 * return the volume of the musicplayer
	 *
	 * @return a float between 0-1, 0 is lowest and 1 highest
	 */
	public static float getMusicVolume() {
		return musicVolume;
	}

	/**
	 * Set the music volume of the game
	 *
	 * @param volume a float between 0-1, 0 is lowest and 1 highest
	 */
	public static void setMusicVolume(float volume) {
		musicVolume = volume;
	}

	/**
	 * Get the effect volume of the game
	 *
	 * @return a float between 0-1, 0 is lowest and 1 highest
	 */
	public static float getEffectVolume() {
		return effectVolume;
	}

	/**
	 * Get the effect volume of the game
	 *
	 * @param volume a float between 0-1, 0 is lowest and 1 highest
	 */
	public static void setEffectVolume(float volume) {
		effectVolume = volume;
	}

	/**
	 * Sets the gamestate.
	 *
	 * @param state int number correlating a specific state. 0 = menu, 1= play, 2=pause, 3 = welcome screen
	 * @param reset true if the gamestate which you are to set as current to should be reset and disposed of before you set it
	 */
	public void setState(int state, boolean reset) {
		if (state == MENU) {
			if (reset) {
				menu.dispose();
				menu = new MenuState(this);
			}
			currentGameState = menu;
		}
		if (state == PLAY) {
			if (reset) {
				play.dispose();
				play = new PlayState(this);
			}
			currentGameState = play;
		}
		if (state == PAUSE) {
			if (reset) {
				pause.dispose();
				pause = new PauseState(this);
			}
			currentGameState = pause;
		}
		if (state == WELCOME) {
			if (reset) {
				welcome.dispose();
				welcome = new WelcomeState(this);
			}
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
	 *
	 * @param batch SpriteBatch containing a collection of sprites.
	 */
	public void draw(SpriteBatch batch) {
		currentGameState.draw(batch);
	}


	/**
	 * Dispose the current state and all the things within it
	 *
	 * @param state the state constant
	 */
	public void dispose(int state) {
		if (state == MENU) {
			menu.dispose();
			menu = new MenuState(this);
		}
		if (state == PLAY) {
			play.dispose();
			play = new PlayState(this);
		}
		if (state == PAUSE) {
			pause.dispose();
			pause = new PauseState(this);
		}
		if (state == WELCOME) {
			welcome.dispose();
			welcome = new WelcomeState(this);
		}
	}
}
