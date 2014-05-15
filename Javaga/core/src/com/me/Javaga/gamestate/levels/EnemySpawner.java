package com.me.Javaga.gamestate.levels;

import com.badlogic.gdx.math.Vector2;
import com.me.Javaga.managers.GameStateManager;
import com.me.Javaga.managers.InformationDrawer;
import com.me.Javaga.spaceobject.Boss;
import com.me.Javaga.spaceobject.Bullet;
import com.me.Javaga.spaceobject.Enemy;
import com.me.Javaga.spaceobject.Player;

import java.util.ArrayList;

/**
 * The class whish is responisble for spawning new enemies and keeping track on the current level
 * Created by Lukas on 2014-05-12.
 */
public class EnemySpawner {
	private ArrayList<Bullet> enemyBullets;
	private ArrayList<Enemy> enemies;
	private Player player;
	private GameStateManager gameStateManager;
	private int time;
	private boolean rest;
	private long currentTime;
	private Level currentLevel;
	private int stageIndex;
	private int levelIndex;

	/**
	 * @param enemyBullets     The arraylist which contains all the enemy bullets
	 * @param enemies          The arraylist in which all enemies should be spawned
	 * @param player           The player of the playstate class
	 * @param gameStateManager The games gamestate manager
	 */
	public EnemySpawner(
			ArrayList<Bullet> enemyBullets, ArrayList<Enemy> enemies, Player player,
			GameStateManager gameStateManager) {
		this.currentLevel = Level.LEVEL4;
		this.stageIndex = -1;
		this.levelIndex = 3;
		this.enemyBullets = enemyBullets;
		this.enemies = enemies;
		this.player = player;
		this.time = 0;
		this.gameStateManager = gameStateManager;
		this.currentTime = System.currentTimeMillis();
	}

	/**
	 * Spawn a new enemy wave
	 *
	 * @param stage The current stage
	 */
	private void setEnemyWave(Level.StageDescription stage) {
		EnemyMovement movement = stage.getMovementType();

		Vector2 start = movement.getStartCoordinate();
		Vector2[] goals = movement.getCoordinates();
		Vector2 direction = movement.getStartDirection();

		float enemyDifferenceX = movement.getdX() / stage.getNumberOfEnemies();
		float enemyDifferenceY = movement.getdY() / stage.getNumberOfEnemies();

		float dX = 0;
		float dY = 0;

		for (int i = 0, j; i < stage.getNumberOfEnemies(); i++) {
			float degree;

			if (i % 2 != 0) {
				j = 1;
			} else {
				j = -1;
			}

			dX += i * j * enemyDifferenceX;
			dY += i * j * enemyDifferenceY;
			degree = (90 / stage.getNumberOfEnemies()) * i * j;
			direction.rotate(degree);

			Enemy enemy;

			if (stage.getEnemyType().isBoss()) {
				enemy = new Boss(start.x + dX,
						start.y + dY,
						stage.getEnemyType(), enemyBullets, player);
			} else {
				enemy = new Enemy(start.x + dX,
						start.y + dY,
						stage.getEnemyType(), enemyBullets, player);
			}

			enemy.setDirection(direction.x, direction.y);

			for (Vector2 vector : goals) {
				enemy.addNewGoal(vector.x + dX,
						vector.y + dY);
			}
			this.enemies.add(enemy);
		}
	}

	/**
	 * If it is allowed to, this method will spawn a new wave of enemies onto the screen
	 */
	public void spawnEnemy() {
		if (!canSpawn()) {
			return;
		}
		Level.StageDescription stage = getNextStage();
		if (stage.isGameOver()) {
			gameStateManager.setState(GameStateManager.WELCOME, true);
			return;
		}
		if (!stage.rest()) {
			setEnemyWave(stage);
		} else {
			rest = true;
		}
		time = stage.time() * 1000;
		currentTime = System.currentTimeMillis();
	}

	/**
	 * Returns the current stage description for the spawn enemies method
	 *
	 * @return The next stageDescritpion or quits the game if there are no more levels
	 */
	private Level.StageDescription getNextStage() {
		if (stageIndex + 1 >= currentLevel.getLevelLength()) {
			stageIndex = -1;
			levelIndex++;
			InformationDrawer.setCurretLevel(levelIndex + 1);
			currentLevel = Level.getLevel(levelIndex + 1);
			player.resetHealth();
		}
		if (levelIndex >= Level.NUMBER_OF_LEVELS) {
			return new Level.StageDescription(true); // tells the game the level is won
		}
		stageIndex++;
		return currentLevel.getStage(stageIndex);
	}

	public boolean canSpawn() {
		if (time == -1000 && !enemies.isEmpty()) {
			return false;
		}

		if (rest) {
			if (System.currentTimeMillis() - currentTime > time) {
				rest = false;
				return true;
			}
			return false;
		}

		return (System.currentTimeMillis() - currentTime > time) || enemies.isEmpty();
	}
}
