package com.me.Javaga.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.managers.*;

/**
 * Created by Dansel on 2014-04-30.
 */
public class WelcomeState extends GameState {

	private static final String START = "start_game.png";
	private ButtonContainer menuContainer;

	public WelcomeState(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

	@Override
	public void init() {
		menuContainer = new ButtonContainer();

		Button startGame = new Button(Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() / 2, gameStateManager) {
			@Override
			public void preformAction() {
				gameStateManager.setState(GameStateManager.PLAY, true);
				MusicManager.startNewSong(MusicManager.PLAYSONG);
			}
		};
		startGame.setSprite("start_game.png");
		menuContainer.addButton(startGame);
	}

	@Override
	public void update() {
		handleInput();
		BackgroundDrawer.update();
	}

	@Override
	public void draw(SpriteBatch batch) {
		BackgroundDrawer.draw(batch);
		menuContainer.draw(batch);
	}

	@Override
	public void handleInput() {
		menuContainer.handleInput();
	}

	@Override
	public void dispose() {
		menuContainer.dispose();
	}
}
