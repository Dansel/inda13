package com.me.Javaga.gamestate;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.*;
import com.me.Javaga.managers.Button;
import com.me.Javaga.managers.GameKeys;
import com.me.Javaga.managers.GameStateManager;
import com.me.Javaga.spaceobject.Bullet;
import com.me.Javaga.spaceobject.Star;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by Dansel on 2014-04-30.
 */
public class PauseState extends GameState {

    private ArrayList<Star> stars;
    private long time; // Keep track of the star animation time
    private static final String PAUSE = "pause.png";
    private static final String QUIT = "quit.png";
    private Button pauseButton;
    private Button quitButton;
    //private Sprite pause;
    //private Rectangle pauseRec;

    public PauseState(GameStateManager gameStateManager) {
        super(gameStateManager);
        init();
    }
	@Override
	public void init() {
        stars = new ArrayList<Star>();
        time = System.currentTimeMillis();


        //Create a new button and override the necisary methods
        pauseButton = new Button(Gdx.graphics.getWidth()/2,
                Gdx.graphics.getHeight()/2, gameStateManager) {
            @Override
            public void preformAction() {
                gameStateManager.setState(GameStateManager.PLAY);
            }
        };

        quitButton = new Button(Gdx.graphics.getWidth()/2,
                Gdx.graphics.getHeight()/2 - 200, gameStateManager) {

            @Override
            public void preformAction() {
                gameStateManager.setState(GameStateManager.MENU);
            }
        };
        pauseButton.setSprite(PAUSE);
        quitButton.setSprite(QUIT);
	}

	@Override
	public void update() {
        handleInput();

        if(System.currentTimeMillis() - time > 200) {
            time = System.currentTimeMillis();
            stars.add(new Star());
        }

        Iterator<Star> iterator = stars.iterator();
        while(iterator.hasNext()) {
            Star star = iterator.next();
            if(!star.checkHealthy()) {
                iterator.remove();
            }
        }

        iterator = stars.iterator();
        while(iterator.hasNext()) {
            Star star = iterator.next();
            star.update();
        }

	}

	@Override
	public void draw(SpriteBatch batch) {
        Iterator<Star> iterator = stars.iterator();
        while(iterator.hasNext()) {
            Star star = iterator.next();
            star.draw(batch);
        }
        pauseButton.draw(batch);
        quitButton.draw(batch);
	}

	@Override
	public void handleInput() {
        // Lets you exit pause with escape
        if(GameKeys.isPressed(GameKeys.ESCAPE)) {
            gameStateManager.setState(GameStateManager.PLAY);
        }
        pauseButton.hover();
        quitButton.hover();
	}

	@Override
	public void dispose() {

	}
}
