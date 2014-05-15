package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.Javaga.gamestate.levels.EnemyDescription;
import com.me.Javaga.managers.GameStateManager;
import com.me.Javaga.managers.InformationDrawer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

;

/**
 * Create object of this class to spawn enemies.
 * Created by Dansel on 2014-05-02.
 */
public class Enemy extends SpaceObject {
	protected ArrayList<Bullet> enemyBullets;
	protected ArrayList<Vector2> goals;
	protected Vector2 direction;
	protected Vector2 currentGoal;
	protected Sound sound;
	protected Player player;
	protected long time;
	protected float shootLimit;
	protected int goalIndex;
	protected Random random;
	protected boolean outsideBorder;
	protected EnemyDescription description;
	protected Rectangle directionBox;

	public Enemy(float xPos, float yPos, EnemyDescription description,
	             ArrayList<Bullet> enemyBullets, Player player) {
		super(xPos, yPos);

		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
		this.description = description;
		health = description.getHealth();
		this.enemyBullets = enemyBullets;
		this.player = player;
		this.time = System.currentTimeMillis();
		init();
	}

	@Override
	public void init() {
		random = new Random();
		setScale(description.getScale());
		spriteSetUp(description.getFilename());

		hitbox.setWidth(sWidth * description.getHitBoxScale()).
				setHeight(sHeight * description.getHitBoxScale());
		sound = Gdx.audio.newSound(Gdx.files.internal("lazer.mp3"));
		shootLimit = description.getBulletType().getShootLimit();
		goals = new ArrayList<Vector2>();
		directionBox = new Rectangle();
		directionBox.setWidth(4).setHeight(4).setCenter(xCenter, yCenter);
		wrap();
	}

	@Override
	public void update() {
		if (isHealthy) {
			xPos += direction.x;
			yPos += direction.y;
			//System.out.println("y: " + yPos);
			//System.out.println("x: " + xPos);

			sprite.setX(xPos);
			sprite.setY(yPos);
			xCenter = xPos + sprite.getWidth() / 2;
			yCenter = yPos + sprite.getHeight() / 2;
			wrap();
			hitbox.setCenter(xCenter, yCenter);
			directionBox.setCenter(xCenter, yCenter);
			if (currentGoal != null && directionBox.contains(currentGoal.x, currentGoal.y)) {
				direction.set(0, 0);
				updateGoal();
			} else {
				updateDirection();
			}
			if (health <= 0) {
				isHealthy = false;
			}
			fire();
		} else {
			hurt();
		}
	}

	@Override
	protected void hurt() {
		if (disposeIndex > 50) {
			isDisposable = true;
		} else {
			disposeIndex++;
			if (disposeIndex % 10 == 0) {
				draw = (draw) ? false : true;
			}
		}
	}

	@Override

	/**
	 * Check if the enemy is outside the game or not
	 */
	public void wrap() {
		if (xCenter > WIDTH || xCenter < 0 || yCenter > HEIGHT || yCenter < 0) {
			outsideBorder = true;
		} else {
			outsideBorder = false;
		}
	}

	/**
	 * Check if any bullet hits the enemy and deals the appropriate damage
	 *
	 * @param bullets An arraylist of bullets
	 * @return true if there was a collision
	 */
	@Override
	public boolean checkForCollision(ArrayList<Bullet> bullets) {
		Iterator<Bullet> iterator = bullets.iterator();
		while (iterator.hasNext()) {
			Bullet bullet = iterator.next();
			if (overlap(bullet)) {
				health -= bullet.getDamage();
				if (health <= 0) {
					InformationDrawer.updatePoints(10);
					isHealthy = false;
				}
				if (!bullet.isIndestructable() || isHealthy) {
					bullet.dispose();
					iterator.remove();
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Fire a shoot
	 */
	public void fire() {
		if (System.currentTimeMillis() - time < shootLimit || outsideBorder) {
			return;
		}
		float dX = xCenter - player.getX(); // Aim for the player
		float dY = (yCenter - sWidth / 2) - player.getY(); // Aim for the player

		if ((yCenter - sWidth / 2) - player.getY() >= 0) { // Dont shoot if the player is behind you

			double radian = Math.atan(dX / dY);
			float degree = (float) (270 - Math.toDegrees(radian));
			float miss = (random.nextBoolean()) ? random.nextFloat() * description.getAccuracy()
					: random.nextFloat() * -1 * description.getAccuracy(); // Makes their aim awful,
			//// probably should do it some other this

			Bullet bullet;
			if (description.getBulletType().isMotionSeeker()) {
				bullet = new MotionSeeker(xCenter, yCenter - sHeight / 2, 90, description.getBulletType(), player);
			} else {
				bullet = new Bullet(xCenter, yCenter - sHeight / 2, degree + miss, description.getBulletType());
			}

			enemyBullets.add(bullet);

			sound.play(GameStateManager.getEffectVolume()); // play lazer
			time = System.currentTimeMillis(); // reset time
		}

	}

	/**
	 * Push the enemey object in a certain direction
	 *
	 * @param speed  The speed of the direction, or the length of the direction vector
	 * @param degree The degree of the direction
	 */
	public void setDirection(float speed, float degree) {
		direction = new Vector2((float) Math.cos(Math.toRadians(degree) * speed),
				(float) Math.sin(Math.toRadians(degree)) * speed);
	}

	/**
	 * Add a new goal to the enemy's list of goals
	 *
	 * @param x x coordinate of the goal
	 * @param y y coordinate of the goal
	 */
	public void addNewGoal(float x, float y) {
		goals.add(new Vector2(x, y));
	}

	/**
	 * Remove the current goal and add new one
	 *
	 * @param x x coordinate of the goal
	 * @param y y coordinate of the goal
	 */
	public void setCurrentGoal(float x, float y) {
		goals.remove(goalIndex);
		Vector2 newGoal = new Vector2(x, y);
		goals.add(goalIndex, newGoal);
		currentGoal = newGoal;
	}

	/**
	 * Update the direction for the enemy object
	 */
	protected void updateDirection() {
		if (currentGoal != null) {
			Vector2 newDirection = new Vector2(currentGoal.x - xCenter, currentGoal.y - yCenter);
			direction.add(newDirection.nor().scl(description.getSpeed()));
			//direction.nor().scl(description.getSpeed());
			direction.nor().scl(description.getSpeed());

		} else {
			if (!goals.isEmpty()) {
				currentGoal = goals.get(0);
			}
		}
	}

	/**
	 * Update the current goal
	 */
	protected void updateGoal() {
		if (goalIndex + 1 < goals.size()) {
			goalIndex++;
			currentGoal = goals.get(goalIndex);
		} else {
			isHealthy = false;
		}
	}

	/**
	 * Dispose all components in the object, no other methods can be called after this
	 */
	@Override
	public void dispose() {
		super.dispose();
		sound.dispose();
	}
}
