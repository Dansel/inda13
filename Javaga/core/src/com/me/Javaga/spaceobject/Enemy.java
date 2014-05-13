package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.Javaga.gamestate.levels.BulletDescription;
import com.me.Javaga.gamestate.levels.EnemyDescription;
import com.me.Javaga.managers.GameStateManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

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
	protected boolean outsideBourder;
	protected EnemyDescription description;
	protected int health;

	public Enemy(float xPos, float yPos, int type,
	             ArrayList<Bullet> enemyBullets, Player player) {
		super(xPos, yPos);

		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
		description = EnemyDescription.getType(type);
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
		sound = Gdx.audio.newSound(Gdx.files.internal("lazer.mp3"));
		shootLimit = BulletDescription.getType(description.getBulletType()).getTime();
		goals = new ArrayList<Vector2>();
		setDirection(20f, 270);
		wrap();
	}

	@Override
	public void update() {
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
		if (currentGoal != null && hitbox.contains(currentGoal.x, currentGoal.y)) {
			direction.set(0, 0);
			updateGoal();
		} else {
			updateDirection();
		}
		if (health <= 0) {
			isHealthy = false;
		}
		fire();
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	@Override
	//TODO
	// Need to decide how we should dispose us of our enemies
	// when they leave the field
	public void wrap() {
		if (xCenter > WIDTH || xCenter < 0 || yCenter > HEIGHT || yCenter < 0) {
			outsideBourder = true;
		} else {
			outsideBourder = false;
		}
	}

	@Override
	public boolean checkHealthy() {
		return isHealthy;
	}

	@Override
	public boolean checkForCollision(ArrayList<Bullet> bullets) {
		Iterator<Bullet> iterator = bullets.iterator();
		while (iterator.hasNext()) {
			Bullet bullet = iterator.next();
			if (overlap(bullet)) {
				health -= bullet.getDamage();
				if (health <= 0) {
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
		if (System.currentTimeMillis() - time < shootLimit || outsideBourder) {
			return;
		}
		float dX = xCenter - player.getX(); // Aim for the player
		float dY = yCenter - player.getY(); // Aim for the player

		if (yCenter - player.getY() >= 0) { // Dont shoot if the player is behind you

			double radian = Math.atan(dX / dY);
			float degree = (float) (270 - Math.toDegrees(radian));
			float miss = (random.nextBoolean()) ? random.nextFloat() * description.getAccuracy()
					: random.nextFloat() * -1 * description.getAccuracy(); // Makes their aim awful,
			//// probably should do it some other this
			enemyBullets.add(new Bullet(xCenter, yCenter - sHeight / 2, degree + miss, description.getBulletType()));

			sound.play(GameStateManager.getEffectVolume()); // play lazer
			time = System.currentTimeMillis(); // reset time
		}

	}

	/**
	 * Push the enemey object in a certain direction
	 *
	 * @param speed
	 * @param degree
	 */
	public void setDirection(float speed, float degree) {
		direction = new Vector2((float) Math.cos(Math.toRadians(degree) * speed),
				(float) Math.sin(Math.toRadians(degree)) * speed);
	}

	public void addNewGoal(float x, float y) {
		goals.add(new Vector2(x, y));
	}

	/**
	 * Remove the current goal and add new one
	 *
	 * @param x
	 * @param y
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
			direction.add(newDirection.nor().scl(0.5f));
			direction.nor().scl(description.getSpeed());
		} else {
			if (!goals.isEmpty()) {
				currentGoal = goals.get(0);
			}
		}
	}

	protected void updateGoal() {
		if (goalIndex + 1 < goals.size()) {
			goalIndex++;
			currentGoal = goals.get(goalIndex);
		} else {
			isHealthy = false;
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		sound.dispose();
	}
}
