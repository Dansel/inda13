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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Dansel on 2014-04-30.
 */
public class PlayState extends GameState {
	private Player player;
	private ArrayList<Bullet> bullets;
	private ArrayList<Bullet> enemyBullets;
	private ArrayList<Enemy> enemies;
	private Level levels;

	public PlayState(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

	@Override
	public void init() {
		bullets = new ArrayList<Bullet>();
		enemyBullets = new ArrayList<Bullet>();
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

		for (Bullet bullet : enemyBullets) {
			bullet.update();
		}
	}

	private void checkHealth() {
		if (!player.checkHealthy()) {

		}
		Iterator<Bullet> bulletIterator = bullets.iterator();
		Iterator<Bullet> enemyBulletIterator = enemyBullets.iterator();
		Iterator<Enemy> enemyIterator = enemies.iterator();

		while (bulletIterator.hasNext()) {
			Bullet bullet = bulletIterator.next();
			if (!bullet.checkHealthy()) {
				bulletIterator.remove();
			}
		}

		while (enemyBulletIterator.hasNext()) {
			Bullet bullet = enemyBulletIterator.next();
			if (!bullet.checkHealthy()) {
				enemyBulletIterator.remove();
			}
		}

		boolean spawEnemy = false;
		while (enemyIterator.hasNext()) {
			Enemy enemy = enemyIterator.next();
			if (enemy.checkForCollision(bullets)) {
				enemyIterator.remove();
				spawEnemy = true;
			}
		}
		if (spawEnemy) {
			spawnEnemies();
		}
		;
/*
		if (player.checkForCollision(enemyBullets)) {
			gameStateManager.setState(GameStateManager.WELCOME, true);
			MusicManager.startNewSong(MusicManager.WELCOMESONG);
		}
		*/
	}

	@Override
	public void draw(SpriteBatch batch) {
		BackgroundDrawer.draw(batch); //draw background
		player.draw(batch); // draw player
		// draw player bullets
		for (Bullet bullet : bullets) {
			bullet.draw(batch);
		}
		//draw enemy bullets
		for (Bullet bullet : enemyBullets) {
			bullet.draw(batch);
		}
		//draw enemies
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
		enemies.add(new Enemy(Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() * 0.8f, 1,
				this.enemyBullets, this.player));
	}
}
