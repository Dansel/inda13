package com.me.Javaga.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.managers.*;

/**
 * Created by Dansel on 2014-04-30.
 */
public class PauseState extends GameState {

	private static final String PAUSE = "resume.png";
	private static final String QUIT = "quit.png";
	private ButtonContainer currentMenu;

	public PauseState(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

	@Override
	public void init() {

		//Create a new button and override the necisary methods
		Button pauseButton = new Button(Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() / 2, gameStateManager) {
			@Override
			public void preformAction() {
				gameStateManager.setState(GameStateManager.PLAY, false);
				MusicManager.play();
			}
		};

		Button quitButton = new Button(Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() / 2 - 200, gameStateManager) {
			@Override
			public void preformAction() {
				gameStateManager.dispose(GameStateManager.PLAY);
				gameStateManager.setState(GameStateManager.WELCOME, true);
				MusicManager.startNewSong(MusicManager.WELCOMESONG);
			}
		};

		pauseButton.setSprite(PAUSE);
		quitButton.setSprite(QUIT);
		currentMenu = new ButtonContainer();
		currentMenu.addButton(pauseButton);
		currentMenu.addButton(quitButton);
	}

	@Override
	public void update() {
		handleInput();
		BackgroundDrawer.update();
	}

	@Override
	public void draw(SpriteBatch batch) {
		BackgroundDrawer.draw(batch);
		currentMenu.draw(batch);
	}

	@Override
	public void handleInput() {
		// Lets you exit pause with escape
		if (GameKeys.isPressed(GameKeys.ESCAPE)) {
			gameStateManager.setState(GameStateManager.PLAY, false);
			MusicManager.play();

		}
		currentMenu.handleInput();
	}

	@Override
	public void dispose() {
		currentMenu.dispose();
	}
}
