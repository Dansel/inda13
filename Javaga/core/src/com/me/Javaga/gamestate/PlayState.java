package com.me.Javaga.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
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
	private Level levels;

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
		spawnEnemies(); //TEMPORARY! FIX-ME! TODO!
	}

	@Override
	public void update() {
		handleInput();
		checkHealth();
		player.update();
		BackgroundDrawer.update();

		for (Enemy enemy : enemies) {
			enemy.update();
		}

		for (Bullet bullet : bullets) {
			bullet.update();
		}
	}

	private void checkHealth() {
		if (!player.checkHealthy()) {

		}
		Iterator<Bullet> bulletIterator = bullets.iterator();
		Iterator<Enemy> enemyIterator = enemies.iterator();

		while (bulletIterator.hasNext()) {
			Bullet bullet = bulletIterator.next();
			if (!bullet.checkHealthy()) {
				bulletIterator.remove();
			}
		}

		while (enemyIterator.hasNext()) {
			Enemy enemy = enemyIterator.next();
			if (enemy.checkForCollision(bullets)) {
				enemyIterator.remove();
			}
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		BackgroundDrawer.draw(batch);
		player.draw(batch);
		for (Bullet bullet : bullets) {
			bullet.draw(batch);
		}
		for (Enemy enemy : enemies) {
			enemy.draw(batch);
		}
	}

	@Override
	public void handleInput() {
		if (GameKeys.isPressed(GameKeys.ESCAPE)) {
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
	public void spawnEnemies() {
		enemies.add(new Enemy(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() * 0.8f, 1));
	}
}
