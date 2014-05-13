package com.me.Javaga.gamestate.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.me.Javaga.managers.GameStateManager;
import com.me.Javaga.spaceobject.Boss;
import com.me.Javaga.spaceobject.Bullet;
import com.me.Javaga.spaceobject.Enemy;
import com.me.Javaga.spaceobject.Player;

import java.util.ArrayList;

/**
 * Created by Lukas on 2014-05-12.
 */
public class EnemySpawner {
	private Level level;
	private ArrayList<Bullet> enemyBullets;
	private ArrayList<Enemy> enemies;
	private Player player;
	private GameStateManager gameStateManager;
	private int time;
	private long currentTime;

	public EnemySpawner(Level level,
	                    ArrayList<Bullet> enemyBullets, ArrayList<Enemy> enemies, Player player,
	                    GameStateManager gameStateManager) {
		this.level = level;
		this.enemyBullets = enemyBullets;
		this.enemies = enemies;
		this.player = player;
		this.time = 0;
		this.gameStateManager = gameStateManager;
		this.currentTime = System.currentTimeMillis();
	}

	private void setEnemyWawe(Level.StageDescription stage) {
		EnemyMovement movement = EnemyMovement.getType(stage.getMovementType());

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

			if (EnemyDescription.isBoss(stage.getEnemyType())) {
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
		time = stage.time() * 1000;
		currentTime = System.currentTimeMillis();
	}

	public void spawnEnemy() {
		Level.StageDescription stage = level.getNextStage();
		if (stage.isGameOver()) {
			gameStateManager.setState(GameStateManager.WELCOME, true);
			return;
		}
		setEnemyWawe(stage);
	}

	public boolean canSpawn() {
		if (time == -1000) {
			return false;
		}
		return System.currentTimeMillis() - currentTime > time;
	}
}
