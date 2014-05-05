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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Dansel on 2014-04-30.
 */
public class PlayState extends GameState {
	private Player player;
	private ArrayList<Bullet> bullets;
	private ArrayList<Enemy> enemies;
	private Level levels;
    private Music musicPlayer;

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

	public void spawnEnemies(){

	}
}
