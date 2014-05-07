package com.me.Javaga.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.gamestate.levels.Level;
import com.me.Javaga.managers.BackgroundDrawer;
import com.me.Javaga.managers.GameKeys;
import com.me.Javaga.managers.GameStateManager;
import com.me.Javaga.managers.MusicManager;
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

    }

	@Override
	public void update() {
        handleInput();
		chechHealth();
		player.update();
        BackgroundDrawer.update();

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
        BackgroundDrawer.draw(batch);
	    player.draw(batch);
	    for(Bullet bullet: bullets) {
		    bullet.draw(batch);
	    }
    }

    @Override
    public void handleInput() {
        if(GameKeys.isPressed(GameKeys.ESCAPE)) {
            MusicManager.pause();
           gameStateManager.setState(GameStateManager.PAUSE, true);
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
}
