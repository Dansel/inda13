package com.me.Javaga.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

    public PauseState(GameStateManager gameStateManager) {
        super(gameStateManager);
        init();
    }
	@Override
	public void init() {
        stars = new ArrayList<Star>();
        time = System.currentTimeMillis();
        pause = new Sprite(new Texture(Gdx.files.internal(FILENAME)));
        pause.setPosition(Gdx.graphics.getWidth()/2 - pause.getWidth()/2, Gdx.graphics.getHeight()/2);
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
	}

	@Override
	public void dispose() {

	}
}
