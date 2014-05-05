package com.me.Javaga.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.gamestate.levels.Level;
import com.me.Javaga.managers.GameKeys;
import com.me.Javaga.managers.GameStateManager;
import com.me.Javaga.spaceobject.Bullet;
import com.me.Javaga.spaceobject.Enemy;
import com.me.Javaga.spaceobject.Player;
import com.me.Javaga.spaceobject.Star;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Dansel on 2014-04-30.
 */
public class PlayState extends GameState {
	private Player player;
	private ArrayList<Bullet> bullets;
	private ArrayList<Enemy> enemies;
    private ArrayList<Star> stars;
	private Level levels;
    private Music musicPlayer;
    private long time;

	public PlayState(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

    @Override
    public void init() {
	    bullets = new ArrayList<Bullet>();
	    enemies = new ArrayList<Enemy>();
	    levels = new Level();
	    player = new Player(Gdx.graphics.getWidth() / 2, 30, bullets);
        stars = new ArrayList<Star>();
        time = System.currentTimeMillis();
        musicPlayer = Gdx.audio.newMusic(Gdx.files.internal("Test.mp3"));
        musicPlayer.play();
        musicPlayer.setLooping(true);
    }

	@Override
	public void update() {
        if(!musicPlayer.isPlaying()) {
            musicPlayer.play();
        }
        handleInput();
		chechHealth();
        updateBackGround();
		player.update();

		for(Bullet bullet: bullets) {
			bullet.update();
		}
	}

	private void chechHealth() {
		if(!player.checkHealthy()) {

		}
		Iterator<Bullet> iterator = bullets.iterator();
		while(iterator.hasNext()) {
			Bullet bullet = iterator.next();
			if(!bullet.checkHealthy()) {
				iterator.remove();
			}
		}
	}

    @Override
    public void draw(SpriteBatch batch) {
        drawBackGround(batch);
	    player.draw(batch);
	    for(Bullet bullet: bullets) {
		    bullet.draw(batch);
	    }
    }

    @Override
    public void handleInput() {
        if(GameKeys.isPressed(GameKeys.ESCAPE)) {
            musicPlayer.pause();
           gameStateManager.setState(GameStateManager.PAUSE);
        }
    }

    @Override
    public void dispose() {
    }

    /**
     * Spawn enemies onto the level
     */
	public void spawnEnemies(){
	}

    /**
     * Update the background logic
     */
    private void updateBackGround() {
        if(System.currentTimeMillis() - time > 200) { // Spawn a new star ever 1/5 second
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

    /**
     * Draw the background, should be used first in the rendering method
     */
    private void drawBackGround(SpriteBatch batch) {
        Iterator<Star> iterator = stars.iterator();
        while(iterator.hasNext()) {
            Star star = iterator.next();
            star.draw(batch);
        }
    }
}
