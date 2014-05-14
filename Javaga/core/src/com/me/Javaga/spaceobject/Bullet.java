package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Javaga.gamestate.levels.BulletDescription;

import java.util.ArrayList;

/**
 * For projectiles
 * Created by Dansel on 2014-04-30.
 */
public class Bullet extends SpaceObject {


	//private final static float ROTATION = 30;
	protected BulletDescription description;
	protected long startTime;

	/**
	 * Create a bullet
	 *
	 * @param xPos        The start x coordinate
	 * @param yPos        The start y coordinate
	 * @param degree      The degree which the bullet should be fired in, 90 for straigth, 180 to the right, 270 for down etc.
	 * @param description A BulletDescription object which specifies all characteristics of the bullet
	 */
	public Bullet(float xPos, float yPos, float degree, BulletDescription description) {
		super(xPos, yPos);
		this.description = description;
		dX = (float) Math.cos(Math.toRadians(degree)) * description.getSpeed();
		dY = (float) Math.sin(Math.toRadians(degree)) * description.getSpeed();
		HEIGHT = Gdx.graphics.getHeight();
		WIDTH = Gdx.graphics.getWidth();
		init();
		sprite.rotate(degree - 90);
		startTime = System.currentTimeMillis();
	}

	/**
	 * Initialize all unitilized fields
	 */
	@Override
	public void init() {
		setScale(description.getScale());
		spriteSetUp(description.getFilename());
	}

	/**
	 * Update the bullet
	 */
	@Override
	public void update() {
		if (isHealthy) {
			yPos += dY;
			xPos += dX;
			xCenter = xPos + sprite.getWidth() / 2;
			yCenter = yPos + sprite.getHeight() / 2;
			//sprite.rotate(ROTATION);
			sprite.setX(xPos);
			sprite.setY(yPos);
			hitbox.setCenter(xCenter, yCenter);
			wrap();
			if (System.currentTimeMillis() - startTime > description.getLifeTime()) {
				isHealthy = false;
			}
		} else {
			hurt();
		}
	}

	/**
	 * Start flashing if the bullet is damaged and will soon be removed
	 */
	@Override
	protected void hurt() {
		if (disposeIndex > 50) {
			isDisposable = true;
		} else {
			disposeIndex++;
			if (disposeIndex % 10 == 0) {
				if (draw) {
					draw = false;
				} else {
					draw = true;
				}
			}
		}
	}

	/**
	 * Dispose of the bullet if it escapes the games boundaries
	 */
	@Override
	public void wrap() {
		if ((xCenter - sWidth / 2 + 100 < 0) || (xCenter + sWidth / 2 - 100 > WIDTH)
				|| (yCenter - sHeight / 2 + 20 < 0) || (yCenter + sHeight / 2 - 20 > HEIGHT)) {
			isHealthy = false;
			isDisposable = true;
		}
	}

	/**
	 * Get the damage which the bullet causes
	 * @return
	 */
	public float getDamage() {
		return description.getDamage();
	}

	/**
	 * Check if the bullet is indesctrible and doesn't get destroyed after it killed something
	 * @return True if the bullet doesn't get destroyed on impact, false if it does
	 */
	public boolean isIndestructable() {
		return description.isIndestructable();
	}

	/**
	 * Check if the bullet collides with other bullets
	 * @param bullets An arrayList of bullets
	 * @return true if the colide, false if the don't
	 */
	@Override
	public boolean checkForCollision(ArrayList<Bullet> bullets) {
		return false;
	}
}
