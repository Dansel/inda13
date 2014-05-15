package com.me.Javaga.gamestate;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.managers.GameStateManager;

/**
 * This abstract class is the
 * Created by Dansel on 2014-04-30.
 */
public abstract class GameState {

	protected GameStateManager gameStateManager;

	public GameState(GameStateManager gameStateManager) {
		this.gameStateManager = gameStateManager;
	}

	/**
	 * Initialize all the components within the state, should be called in the constructor of all subclasses
	 */
	public abstract void init();

	/**
	 * Update the gamestate
	 */
	public abstract void update();

	/**
	 * Draw something onto the canvas
	 *
	 * @param batch A sprite batch
	 */
	public abstract void draw(SpriteBatch batch);

	/**
	 * Do something based on the user input
	 */
	public abstract void handleInput();

	/**
	 * Disposes all the sprites and sounds within the game state to avoid memory leakage
	 */
	public abstract void dispose();
}
