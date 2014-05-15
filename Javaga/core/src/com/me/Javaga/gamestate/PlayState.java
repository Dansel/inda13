package com.me.Javaga.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.gamestate.levels.EnemySpawner;
import com.me.Javaga.managers.*;
import com.me.Javaga.spaceobject.Bullet;
import com.me.Javaga.spaceobject.Enemy;
import com.me.Javaga.spaceobject.Player;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class handles all the game logic and iterates over all the objects in the game
 * Created by Dansel on 2014-04-30.
 */
public class PlayState extends GameState {
	private Player player;
	private ArrayList<Bullet> bullets;
	private ArrayList<Bullet> enemyBullets;
	private ArrayList<Enemy> enemies;
	private EnemySpawner spawner;

	public PlayState(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

	@Override
	public void init() {
		bullets = new ArrayList<Bullet>();
		enemyBullets = new ArrayList<Bullet>();
		enemies = new ArrayList<Enemy>();
		player = new Player(Gdx.graphics.getWidth() / 2, 30, bullets);
		spawner = new EnemySpawner(enemyBullets, enemies, player, gameStateManager);
		InformationDrawer.reset();
	}

	@Override
	public void update() {
		spawnEnemies();
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
		if (player.isDisposable()) {
			gameStateManager.setState(GameStateManager.WELCOME, true);
			MusicManager.startNewSong(MusicManager.WELCOMESONG);
		}
		Iterator<Bullet> bulletIterator = bullets.iterator();
		Iterator<Bullet> enemyBulletIterator = enemyBullets.iterator();
		Iterator<Enemy> enemyIterator = enemies.iterator();

		while (bulletIterator.hasNext()) {
			Bullet bullet = bulletIterator.next();
			if (bullet.isDisposable()) {
				bullet.dispose();
				bulletIterator.remove();
			}
		}

		while (enemyBulletIterator.hasNext()) {
			Bullet bullet = enemyBulletIterator.next();
			if (bullet.isDisposable()) {
				bullet.dispose();
				enemyBulletIterator.remove();
			}
		}

		while (enemyIterator.hasNext()) {
			Enemy enemy = enemyIterator.next();
			if (enemy.checkHealthy()) {
				enemy.checkForCollision(bullets);
			}
			if (enemy.isDisposable()) {
				enemyIterator.remove();
			}
		}
		if (player.checkHealthy()) {
			player.checkForCollision(enemyBullets);
		}
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

		InformationDrawer.draw(batch);
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

		player.dispose();
		player = null;

		Iterator<Bullet> bulletIterator = bullets.iterator();
		Iterator<Bullet> enemyBulletIterator = enemyBullets.iterator();
		Iterator<Enemy> enemyIterator = enemies.iterator();

		while (bulletIterator.hasNext()) {
			Bullet bullet = bulletIterator.next();
			bullet.dispose();
			bulletIterator.remove();
		}

		while (enemyBulletIterator.hasNext()) {
			Bullet bullet = enemyBulletIterator.next();
			bullet.dispose();
			enemyBulletIterator.remove();
		}

		while (enemyIterator.hasNext()) {
			Enemy enemy = enemyIterator.next();
			enemy.dispose();
			enemyIterator.remove();
		}
	}

	/**
	 * Spawn enemies onto the level
	 */
	public void spawnEnemies() {
		spawner.spawnEnemy();
	}
}
