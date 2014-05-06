package com.me.Javaga.gamestate;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.*;
import com.me.Javaga.managers.*;
import com.me.Javaga.spaceobject.Bullet;
import com.me.Javaga.spaceobject.Star;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by Dansel on 2014-04-30.
 */
public class PauseState extends GameState {

    private static final String PAUSE = "resume.png";
    private static final String QUIT = "quit.png";
    private Button pauseButton;
    private Button quitButton;
    private ButtonContainer currentMenu;

    public PauseState(GameStateManager gameStateManager) {
        super(gameStateManager);
        init();
    }
	@Override
	public void init() {

        //Create a new button and override the necisary methods
        pauseButton = new Button(Gdx.graphics.getWidth()/2,
                Gdx.graphics.getHeight()/2, gameStateManager) {
            @Override
            public void preformAction() {
                gameStateManager.setState(GameStateManager.PLAY);
                MusicManeger.play();
            }
        };

        quitButton = new Button(Gdx.graphics.getWidth()/2,
                Gdx.graphics.getHeight()/2 - 200, gameStateManager) {

            @Override
            public void preformAction() {
                gameStateManager.setState(GameStateManager.WELCOME);
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
       // backgroundDrawer.update();
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
        if(GameKeys.isPressed(GameKeys.ESCAPE)) {
            gameStateManager.setState(GameStateManager.PLAY);
            MusicManeger.play();

        }
        currentMenu.handleInput();
	}

	@Override
	public void dispose() {

	}
}
