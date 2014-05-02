package com.me.Javaga.spaceobject;

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

	protected float SCALEFACTOR;

	protected Rectangle hitbox;


	public SpaceObject(float xPos, float yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.isHealthy = true;
	}


	public abstract void init();

	public abstract void update();

	public abstract void draw(SpriteBatch batch);

	public abstract void setScale(float scaleFactor);

	public abstract void wrap();

	public abstract boolean checkHealthy();

	public abstract  boolean overlap(SpaceObject obj);

	public abstract Rectangle getHitbox();
}
