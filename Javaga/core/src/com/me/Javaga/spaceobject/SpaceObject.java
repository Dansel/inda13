package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * An abstract class describing the essentials of all
 * space objects in the game
 * Created by Dansel on 2014-04-30.
 */
public abstract class SpaceObject {

	protected float xPos;
	protected float yPos;
	protected Sprite sprite;
	protected boolean isHealthy;
	protected boolean isDisposable;
	protected boolean draw;

	protected float HEIGHT;
	protected float WIDTH;

	protected float sWidth;
	protected float sHeight;

	protected float xCenter;
	protected float yCenter;

	protected float dX;
	protected float dY;
	protected float health;

	protected float SCALEFACTOR;

	protected Rectangle hitbox;
	protected int disposeIndex;


	public SpaceObject(float xPos, float yPos) {
		this.xCenter = xPos;
		this.yCenter = yPos;
		this.isHealthy = true;
	}


	/**
	 * Properly initialize the SpaceObject with sprites and logic, should be called
	 * in the subclasses constructor and no other method should be called before
	 * this method
	 */
	public abstract void init();

	/**
	 * Update the logic of the object
	 */
	public abstract void update();

	/**
	 * Draw the SpaceObject ont the canvas
	 *
	 * @param batch A Sprite batch which draws the sprite onto
	 *              the canvas
	 */
	public void draw(SpriteBatch batch) {
		if (isHealthy || draw) {
			sprite.draw(batch);
		}
	}

	public void setScale(float scaleFactor) {
		SCALEFACTOR = scaleFactor;
	}

	/**
	 *
	 */
	public abstract void wrap();

	/**
	 * Check if the object is healthy
	 *
	 * @return True if it is healthy, false if it should be discarded
	 */
	public boolean checkHealthy() {
		return isHealthy;
	}

	/**
	 * Check if an object should be discarded and the dispose method should be called
	 *
	 * @return True if the obejct should be disposed as soon as possible, otherwise false
	 */
	public boolean isDisposable() {
		return isDisposable;
	}


	/**
	 *
	 */
	public abstract boolean checkForCollision(ArrayList<Bullet> bullets);

	/**
	 * See if to spaceobjects overlap each other, which means they have colided
	 *
	 * @param obj A spaceObject
	 * @return true if they overlap, false if they don't
	 */
	public boolean overlap(SpaceObject obj) {
		return hitbox.overlaps(obj.getHitbox());
	}

	/**
	 * Return a rectangle stating the area of the sprite
	 *
	 * @return A rectangle
	 */
	public Rectangle getHitbox() {
		return hitbox;
	}

	public void spriteSetUp(String filename) {
		sprite = new Sprite(new Texture(Gdx.files.internal(filename)));

		xPos = xCenter - sprite.getWidth() / 2;
		yPos = yCenter - sprite.getHeight() / 2;

		sprite.setX(xPos);
		sprite.setY(yPos);

		sprite.setScale(SCALEFACTOR);
		sWidth = sprite.getWidth() * SCALEFACTOR;
		sHeight = sprite.getHeight() * SCALEFACTOR;

		hitbox = new Rectangle();
		hitbox.setHeight(sHeight).setWidth(sWidth).setCenter(xCenter, yCenter);
	}

	/**
	 * Return the x position of the player
	 *
	 * @return the x position of the player's centrum
	 */
	public float getX() {
		return this.xCenter;
	}

	/**
	 * Return the y position of the player
	 *
	 * @return the y position of the player's centrum
	 */
	public float getY() {
		return this.yCenter;
	}

	/**
	 * Creates a flashy effect when the object is damaged
	 */
	protected void hurt() {
		if (health <= 0) {
			isDisposable = true;
		} else {
			if (disposeIndex > 100) {
				isHealthy = true;
				draw = true;
				disposeIndex = 0;
				return;
			}
			disposeIndex++;
			if (disposeIndex % 10 == 0) {
				draw = (draw) ? false : true;
			}
		}
	}

	public void dispose() {
		sprite.getTexture().dispose();
	}
}
