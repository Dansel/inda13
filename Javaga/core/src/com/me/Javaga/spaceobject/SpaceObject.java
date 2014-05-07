package com.me.Javaga.spaceobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Dansel on 2014-04-30.
 */
public abstract class SpaceObject {

	protected float xPos;
	protected float yPos;
	protected Sprite sprite;
	protected boolean isHealthy;

	protected float HEIGHT;
	protected float WIDTH;

	protected float sWidth;
	protected float sHeight;

	protected float xCenter;
	protected float yCenter;

	protected float dX;
	protected float dY;

	protected float SCALEFACTOR;

	protected Rectangle hitbox;


	public SpaceObject(float xPos, float yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
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
     * @param batch A Sprite batch which draws the sprite onto
     *              the canvas
     */
	public abstract void draw(SpriteBatch batch);

    public void setScale(float scaleFactor) {
        SCALEFACTOR = scaleFactor;
        sprite.setScale(SCALEFACTOR);
    }

    /**
     *
     */
	public abstract void wrap();

    /**
     * Check if the object is healthy
     * @return True if it is healthy, false if it should be discarded
     */
	public abstract boolean checkHealthy();

    /**
     * See if to spaceobjects overlap each other, which means they have colided
     * @param obj A spaceObject
     * @return true if they overlap, false if they don't
     */
    public boolean overlap(SpaceObject obj) {
        return hitbox.overlaps(obj.getHitbox());
    }

    /**
     * Return a rectangle stating the area of the sprite
     * @return A rectangle
     */
    public Rectangle getHitbox() {
        return hitbox;
    }

	public void spriteSetUp(String FILENAME){
		sprite = new Sprite(new Texture(Gdx.files.internal(FILENAME)));
		sprite.setX(xPos);
		sprite.setY(yPos);

		sWidth = sprite.getWidth()*SCALEFACTOR;
		sHeight = sprite.getHeight()*SCALEFACTOR;

		//shift position down and to the left so we draw the sprite centered.
		xPos -= sprite.getWidth()/2;
		yPos -= sprite.getHeight()/2;

		xCenter = xPos + sprite.getWidth()/2;
		yCenter = yPos + sprite.getHeight()/2;

		hitbox = new Rectangle();
		hitbox.setHeight(sHeight).setWidth(sWidth).setCenter(xCenter,yCenter);
	}
}
