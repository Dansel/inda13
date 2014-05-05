package com.me.Javaga.gamestate;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.*;
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
    private static final String FILENAME = "pause.png";
    private Sprite pause;
    private Rectangle pauseRec;

    public PauseState(GameStateManager gameStateManager) {
        super(gameStateManager);
        init();
    }
	@Override
	public void init() {
        stars = new ArrayList<Star>();
        time = System.currentTimeMillis();
        pause = new Sprite(new Texture(Gdx.files.internal(FILENAME)));
        pause.setPosition(Gdx.graphics.getWidth()/2 - pause.getWidth()/2,
                Gdx.graphics.getHeight()/2);
        // Making a quick Botton for test, will probably be changed
        pauseRec = new Rectangle(Gdx.graphics.getWidth()/2 - pause.getWidth()/2,
                Gdx.graphics.getHeight()/2,
                pause.getWidth(), pause.getHeight());
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
        pause.draw(batch);
	}

	@Override
	public void handleInput() {
        if(GameKeys.isPressed(GameKeys.ESCAPE)) {
            gameStateManager.setState(GameStateManager.PLAY);
        }

        if(pauseRec.contains((float) GameKeys.xMouse(), (float) GameKeys.yMouse())) {
            System.out.print("jkljökjkll");
            pause.setColor(Color.BLUE);
        } else {
            pause.setColor(Color.WHITE);
        }

	}

	@Override
	public void dispose() {

	}
}
